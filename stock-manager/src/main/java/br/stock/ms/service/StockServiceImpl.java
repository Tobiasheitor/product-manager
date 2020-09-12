package br.stock.ms.service;

import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.entity.Container;
import br.stock.ms.exceptions.NotFoundException;
import br.stock.ms.repository.ContainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ContainerRepository repository;

    @Override
    public Container newOrder(ContainerDTO containerDTO) {

        Container container = mapper.map(containerDTO, Container.class);

        Container save = repository.save(container);

        return save;
    }

    @Override
    public Container getOrder(Integer id) {
        Optional<Container> response = repository.findById(id);

        return response.orElseThrow(() -> new NotFoundException("Order not found on local database"));
    }

}
