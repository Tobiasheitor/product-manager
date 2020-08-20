package org.product.services;

import org.product.dto.ProductDTO;
import org.product.entities.Product;

import java.util.List;

public interface ProductService {

    Product newProduct(ProductDTO product);

    List<Product> allProducts();

}
