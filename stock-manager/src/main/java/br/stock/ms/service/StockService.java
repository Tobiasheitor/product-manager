package br.stock.ms.service;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.dto.ContainerResponseDTO;

import java.util.List;

public interface StockService {

    ContainerResponseDTO newOrder(ContainerDTO container);
    ContainerResponseDTO getOrder(Integer id);
    List<ContainerResponseDTO> getAllOrders();

}
