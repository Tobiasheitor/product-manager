package br.stock.ms.service;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.dto.ContainerResponseDTO;

public interface StockService {

    ContainerResponseDTO newOrder(ContainerDTO container);
    ContainerResponseDTO getOrder(Integer id);

}
