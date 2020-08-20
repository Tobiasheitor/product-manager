package org.product.exceptions;

public class ProductNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Product not found";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
