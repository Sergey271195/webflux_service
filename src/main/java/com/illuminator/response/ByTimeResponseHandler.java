package com.illuminator.response;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DimensionResponse;
import com.illuminator.dto.ResponseDtoBase;
import com.illuminator.entity.source.SourceSuperclass;
import com.illuminator.util.DimensionProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ByTimeResponseHandler {

    @Autowired
    private SourceRepositoryHolder repositoryHolder;

    public void handleResponse(ByTimeResponseDto responseDto) {
        String dimension = responseDto.getQuery().getDimensions().get(0);
        Class<? extends SourceSuperclass> source = DimensionProjections.dimensionStringToSourceRegistry.get(dimension);
        Serializable dimensionId = responseDto.getData().get(0).getDimensions().get(0).getId();
        System.out.println("Find by id: " + repositoryHolder.getSourceRepository(source).findByMetrikaId(dimensionId));
        System.out.println("Handling Response");
        System.out.println(responseDto);
    }

}
