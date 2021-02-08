package com.illuminator.response;

import com.illuminator.dto.ResponseDtoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ByTimeResponseHandler {

    @Autowired
    private SourceRepositoryHolder repositoryHolder;

    public void handleResponse(ResponseDtoBase responseDto) {
        System.out.println("Handling Response");
        System.out.println(responseDto);
        System.out.println(repositoryHolder.getAdvEngineRepository().findByMetrikaId("ya_direct"));
    }

}
