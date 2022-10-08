package jpdeimos.minicapstone.service;

import jpdeimos.minicapstone.dto.ProductDTO;
import jpdeimos.minicapstone.entity.ProductEntity;
import jpdeimos.minicapstone.exception.UserAlreadyExist;
import jpdeimos.minicapstone.model.ProductRequest;
import jpdeimos.minicapstone.repository.ProductRepository;
import jpdeimos.minicapstone.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<ProductDTO> getAllProducts() {
        // Get all data from database
       List<ProductEntity> allProducts = productRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

        // Initialize DTO
       List<ProductDTO> allProductsDTO = new ArrayList<>();

       allProducts.forEach(product -> {
           allProductsDTO.add(modelMapper.map(product, ProductDTO.class));
       });
        return allProductsDTO;
    }

    public List<ProductDTO> addProduct(ProductRequest newProduct) {

        // Save new product to database
        productRepository.save(ProductEntity
                .builder()
                .productId(UUID.randomUUID())
                .productName(newProduct.getProductName())
                .imageLink(null)
                .price(newProduct.getPrice())
                .ratings(newProduct.getRatings())
                .type(newProduct.getType())
                .filter(newProduct.getFilter())
                .description(newProduct.getDescription())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllProducts();
    }

    public List<ProductDTO> deleteProduct(UUID productId) {

        // Get products
        ProductEntity product = productRepository.findByProductId(productId);

        // Check if product exist
        if(product == null) throw new UserAlreadyExist("Product doesn't exist");

        // Delete product
        productRepository.deleteByProductId(productId);

        return getAllProducts();
    }
}
