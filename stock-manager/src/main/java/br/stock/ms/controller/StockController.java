package br.stock.ms.controller;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.dto.ContainerResponseDTO;
import br.stock.ms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping("/container")
    public ResponseEntity<ContainerResponseDTO> newOrder(@RequestBody ContainerDTO container) {
        return ResponseEntity.ok(service.newOrder(container));
    }

    @GetMapping("container/{id}")
    public ResponseEntity<ContainerResponseDTO> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOrder(id));
    }

    @GetMapping("/containers")
    public ResponseEntity<List<ContainerResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }

}
