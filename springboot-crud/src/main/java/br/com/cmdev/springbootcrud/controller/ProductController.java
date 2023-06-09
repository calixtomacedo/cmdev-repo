package br.com.cmdev.springbootcrud.controller;

import br.com.cmdev.springbootcrud.dto.ProductRecordDto;
import br.com.cmdev.springbootcrud.model.ProductModel;
import br.com.cmdev.springbootcrud.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecord) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecord, productModel);
        var productResponse = ResponseEntity.status(HttpStatus.CREATED).body(repository.save(productModel));
        return productResponse;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> productList = repository.findAll();
        if(!productList.isEmpty()){
            for(ProductModel product : productList){
                UUID id = product.getUuid();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable("id") UUID uuid) {
        Optional<ProductModel> product = repository.findById(uuid);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        product.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") UUID uuid, @RequestBody @Valid ProductRecordDto productRecord) {
        Optional<ProductModel> product = repository.findById(uuid);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = product.get();
        BeanUtils.copyProperties(productRecord, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") UUID uuid) {
        Optional<ProductModel> product = repository.findById(uuid);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        repository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

}
