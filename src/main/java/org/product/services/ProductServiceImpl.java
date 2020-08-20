package org.product.services;

import org.modelmapper.ModelMapper;
import org.product.dto.ProductDTO;
import org.product.entities.Product;
import org.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Product newProduct(ProductDTO product) {
        Product saved;

        saved = repository.save(mapper.<Product>map(product, Product.class));

        return saved;
    }

    @Override
    public List<Product> allProducts() {
        List<Product> response = new ArrayList<>();

        Iterable<Product> allProducts = repository.findAll();

        allProducts.iterator().forEachRemaining(response::add);

        return response;
    }
}
