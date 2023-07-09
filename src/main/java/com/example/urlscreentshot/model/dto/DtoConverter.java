package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DtoConverter {

    private static ModelMapper modelMapper = new ModelMapper();

    public static UrlDto createUrl(String url){
        return new UrlDto(UrlUtil.convertToSha256(url), url, UrlStatus.PENDING, UrlUtil.getCurrentTimestamp());
    }

    public static UrlRs toUrlResponse(UrlDto urlDto){
        return modelMapper.map(urlDto, UrlRs.class);
    }
}
