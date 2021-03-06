package br.product.ms.controller;

import br.product.ms.dto.ProductDTO;
import br.product.ms.dto.ProductIdsDTO;
import br.product.ms.entities.Product;
import br.product.ms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> response = service.allProducts();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {

        Product response = service.getProduct(id);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product) {

        Product response = service.updateProduct(id, product);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {

        service.deleteProduct(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/products")
    public ResponseEntity validateProducts(@RequestBody @Valid ProductIdsDTO products) {

        service.validateProducts(products);

        return ResponseEntity.ok().build();
    }
}
