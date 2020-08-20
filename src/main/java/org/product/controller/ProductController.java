package org.product.controller;

import org.product.dto.ProductDTO;
import org.product.entities.Product;
import org.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public ResponseEntity<Product> newProduct(@RequestBody ProductDTO product) {

        Product newProduct = service.newProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> response = service.allProducts();

        return ResponseEntity.ok().body(response);
    }

}
