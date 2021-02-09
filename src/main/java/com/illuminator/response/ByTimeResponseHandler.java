package com.illuminator.response;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DimensionResponse;
import com.illuminator.dto.ResponseDtoBase;
import com.illuminator.entity.source.SourceSuperclass;
import com.illuminator.repository.source.BaseSourceRepository;
import com.illuminator.util.DimensionProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class ByTimeResponseHandler {

    @Autowired
    private SourceRepositoryHolder repositoryHolder;

    public void handleResponse(ByTimeResponseDto responseDto) {
        String dimensionName = responseDto.getQuery().getDimensions().get(0);
        Class<? extends SourceSuperclass> source = DimensionProjections.dimensionStringToSourceRegistry.get(dimensionName);
        DimensionResponse dimension = responseDto.getData().get(0).getDimensions().get(0);
        Serializable dimensionId = dimension.getId();
        BaseSourceRepository sourceRepo = repositoryHolder.getSourceRepository(source);
        Optional<SourceSuperclass> sourceFromDb = sourceRepo.findByMetrikaId("dimensionId");
        SourceSuperclass newInstance = DimensionProjections.getSourceSuperclassInstance(source);
        newInstance.setName(dimension.getName());
        newInstance.setMetrikaId(dimension.getId());

        System.out.println("Find by id: ");
        System.out.println("Handling Response");
        System.out.println(responseDto);
    }

}
