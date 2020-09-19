package br.stock.ms.exceptions;

public class ProductIntegrationException extends RuntimeException {
    private static final long serialVersionUID = -3228288724318419944L;

    public ProductIntegrationException(String message) {
        super(message);
    }
}
