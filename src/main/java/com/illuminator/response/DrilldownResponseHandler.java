package com.illuminator.response;

import com.illuminator.dto.DrilldownResponseDto;

public class DrilldownResponseHandler {

    private final DrilldownResponseDto responseDto;

    public DrilldownResponseHandler(DrilldownResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    public void handleResponse() {
        System.out.println(responseDto);
    }

}
