package br.stock.ms.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2872013234568644098L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
