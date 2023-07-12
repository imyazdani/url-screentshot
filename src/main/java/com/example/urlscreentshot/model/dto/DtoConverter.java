package com.example.urlscreentshot.model.dto;

import com.example.urlscreentshot.model.enums.UrlStatus;
import com.example.urlscreentshot.model.response.UrlRs;
import com.example.urlscreentshot.util.UrlUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class DtoConverter {

    private final UrlUtil urlUtil;

    private ModelMapper modelMapper = new ModelMapper();

    public UrlDto createUrl(String url){
        return new UrlDto(urlUtil.convertToSha256(url), url, UrlStatus.PENDING, urlUtil.getCurrentTimestamp());
    }

    public UrlRs toUrlResponse(UrlDto urlDto){
        return modelMapper.map(urlDto, UrlRs.class);
    }
}
