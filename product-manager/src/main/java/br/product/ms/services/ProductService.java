package br.product.ms.services;

import br.product.ms.dto.ProductDTO;
import br.product.ms.entities.Product;

import java.util.List;

public interface ProductService {

    Product newProduct(ProductDTO product);

    List<Product> allProducts();

    Product updateProduct(Integer id, ProductDTO productDTO);

    Product getProduct(Integer id);

    void deleteProduct(Integer id);

}
