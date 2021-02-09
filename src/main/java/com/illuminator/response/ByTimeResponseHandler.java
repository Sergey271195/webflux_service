package com.illuminator.response;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DimensionResponse;
import com.illuminator.dto.ResponseDtoBase;
import com.illuminator.entity.source.SourceSuperclass;
import com.illuminator.util.DimensionProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ByTimeResponseHandler {

    @Autowired
    private SourceRepositoryHolder repositoryHolder;

    public void handleResponse(ByTimeResponseDto responseDto) {
        String dimension = responseDto.getQuery().getDimensions().get(0);
        Class<? extends SourceSuperclass> source = DimensionProjections.dimensionStringToSourceRegistry.get(dimension);
        System.out.println("Find by id: " + repositoryHolder.getSourceRepository(source).findBy
        System.out.println("Handling Response");
        System.out.println(responseDto);
        System.out.println(responseDto.getQuery().getDimensions().get(0));
        System.out.println(repositoryHolder.getAdvEngineRepository().findByMetrikaId("ya_direct"));
    }

}
