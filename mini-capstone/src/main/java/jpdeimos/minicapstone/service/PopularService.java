package jpdeimos.minicapstone.service;

import jpdeimos.minicapstone.dto.PopularDTO;
import jpdeimos.minicapstone.entity.PopularEntity;
import jpdeimos.minicapstone.exception.UserAlreadyExist;
import jpdeimos.minicapstone.model.PopularRequest;
import jpdeimos.minicapstone.repository.PopularRepository;
import jpdeimos.minicapstone.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PopularService {

    private final PopularRepository popularRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<PopularDTO> getAllPopularProducts() {
        // Get all data from database
        List<PopularEntity> allPopular = popularRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

        // Initialize DTO
        List<PopularDTO> allPopularDTO = new ArrayList<>();

        allPopular.forEach(popular -> {
            allPopularDTO.add(modelMapper.map(popular, PopularDTO.class));
        });
        return allPopularDTO;
    }

    public List<PopularDTO> addPopularProduct(PopularRequest newPopular) {
        // Save new blog to database
        popularRepository.save(PopularEntity
                .builder()
                .productId(UUID.randomUUID())
                .productName(newPopular.getProductName())
                .imageLink(null)
                .price(newPopular.getPrice())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllPopularProducts();
    }

    public List<PopularDTO> deletePopularProduct(UUID productId) {
        // Get Popular
        PopularEntity popular = popularRepository.findByProductId(productId);

        // Check if Popular exist
        if(popular == null) throw new UserAlreadyExist("Blog doesn't exist.");

        // Delete Popular
        popularRepository.deleteByProductId(productId);

        return getAllPopularProducts();
    }


}
