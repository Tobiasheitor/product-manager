package org.product.services;

import org.modelmapper.ModelMapper;
import org.product.dto.ProductDTO;
import org.product.entities.Product;
import org.product.exceptions.ProductNotFoundException;
import org.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Product newProduct(ProductDTO product) {
        Product saved;

        saved = repository.save(mapper.map(product, Product.class));

        return saved;
    }

    @Override
    public List<Product> allProducts() {
        List<Product> response = new ArrayList<>();

        Iterable<Product> allProducts = repository.findAll();

        allProducts.iterator().forEachRemaining(response::add);

        return response;
    }

    @Override
    public Product updateProduct(Integer id, ProductDTO productDTO) {
        Product product = mapper.map(productDTO, Product.class);
        product.setId(id);

        Product response = repository.save(product);

        return response;
    }

    @Override
    public Product getProduct(Integer id) {

        Optional<Product> response = repository.findById(id);

        return response.orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.findById(id).orElseThrow(ProductNotFoundException::new);
        repository.deleteById(id);
    }
}
