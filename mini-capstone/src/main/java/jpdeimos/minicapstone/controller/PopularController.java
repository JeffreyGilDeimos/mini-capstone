package jpdeimos.minicapstone.controller;

import jpdeimos.minicapstone.dto.PopularDTO;
import jpdeimos.minicapstone.model.PopularRequest;
import jpdeimos.minicapstone.service.PopularService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/popular")
@RequiredArgsConstructor
public class PopularController {

    private final PopularService popularService;

    @GetMapping("/getAll")
    public List<PopularDTO> getAllPopularProducts () {
        return popularService.getAllPopularProducts();
    }

    @PutMapping("/add")
    public List<PopularDTO> addPopularProduct(@RequestBody PopularRequest popularRequest) {
        return popularService.addPopularProduct(popularRequest);
    }

    @DeleteMapping("/delete/{productId}")
    public List<PopularDTO> deletePopularProduct(@PathVariable UUID productId) {
        return popularService.deletePopularProduct(productId);
    }
}
