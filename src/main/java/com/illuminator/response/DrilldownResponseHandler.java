package com.illuminator.response;

import com.illuminator.dto.DrilldownResponseDto;
import org.springframework.stereotype.Service;

@Service
public class DrilldownResponseHandler {

    public void handleResponse(DrilldownResponseDto responseDto) {
        System.out.println(responseDto);
    }

}
