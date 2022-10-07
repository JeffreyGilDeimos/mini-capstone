package jpdeimos.minicapstone.controller;

import jpdeimos.minicapstone.dto.ProductDTO;
import jpdeimos.minicapstone.model.ProductRequest;
import jpdeimos.minicapstone.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/add")
    public List<ProductDTO> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }


}
