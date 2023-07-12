package com.example.urlscreentshot.service.impl;

import com.example.urlscreentshot.model.dto.UrlDto;
import com.example.urlscreentshot.service.IScreenshot;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Service
@Slf4j
public class ScreenshotImpl implements IScreenshot {

    @Value("${app.storage-path}")
    private String storagePath;

    public void takeScreenshot(UrlDto urlDto) throws IOException {

        String filePath = storagePath + urlDto.getUrlId() + ".png";

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(urlDto.getUrl());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath));

        driver.quit();
    }
}
