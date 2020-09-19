package br.stock.ms.client;

import br.stock.ms.dto.ProductExceptionDTO;
import br.stock.ms.dto.ProductIdsDTO;
import br.stock.ms.exceptions.ProductIntegrationException;
import br.stock.ms.exceptions.ProductNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ProductProxy {

    @Autowired
    private ProductClient client;

    @Autowired
    private ObjectMapper mapper;

    public void validateProducts(List<Integer> ids) {
        try {
            log.info("Calling product-manager client");
            client.validateProducts(new ProductIdsDTO(ids));
            log.info("product-manager client successfully called");
        } catch (FeignException ex) {
            handleError(ex);
        }
    }

    private void handleError(FeignException ex) {
        if (ex.status() == HttpStatus.NOT_FOUND.value()) {
            String[] message = ex.getMessage().split("content:\n");
            ProductExceptionDTO productException;

            try {
                productException = mapper.readValue(message[1], ProductExceptionDTO.class);
            } catch (IOException ioException) {
                log.error("ProductProxy.handleError() - Error to parse response", ioException);
                throw new ProductNotFoundException("Error to validate product - error to read stack");
            }

            throw new ProductNotFoundException(productException.getMessage());
        }
        throw new ProductIntegrationException(ex.getMessage());
    }

}
