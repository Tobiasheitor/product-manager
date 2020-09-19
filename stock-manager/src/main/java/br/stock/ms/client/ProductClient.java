package br.stock.ms.client;

import br.stock.ms.dto.ProductIdsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${app.product-manager.name}", url = "${app.product-manager.endpoint}")
public interface ProductClient {

    @PostMapping(value = "${app.product-manager.paths.products}")
    void validateProducts(@RequestBody ProductIdsDTO products);
}
