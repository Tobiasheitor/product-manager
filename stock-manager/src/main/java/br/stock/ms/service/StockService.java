package br.stock.ms.service;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.entity.Container;

public interface StockService {

    Container newOrder(ContainerDTO container);
}
