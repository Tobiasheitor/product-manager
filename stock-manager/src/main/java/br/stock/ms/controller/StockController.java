package br.stock.ms.controller;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.entity.Container;
import br.stock.ms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping("/container")
    public ResponseEntity<Container> newOrder(@RequestBody ContainerDTO container) {
        return ResponseEntity.ok(service.newOrder(container));
    }

    @GetMapping("container/{id}")
    public ResponseEntity<Container> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOrder(id));
    }

}
