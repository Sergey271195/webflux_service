package com.illuminator.response;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DrilldownResponseDto;
import com.illuminator.dto.ResponseDtoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseHandler {

    @Autowired
    private ByTimeResponseHandler byTimeResponseHandler;

    @Autowired
    private DrilldownResponseHandler drilldownResponseHandler;

    public void handleResponse(ResponseDtoBase responseDto) {
        if (responseDto.getClass() == ByTimeResponseDto.class) {
            byTimeResponseHandler.handleResponse((ByTimeResponseDto) responseDto);
        } else {
            drilldownResponseHandler.handleResponse((DrilldownResponseDto) responseDto);
        }
    }

}
