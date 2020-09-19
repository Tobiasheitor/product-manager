package br.stock.ms.service;

import br.stock.ms.client.ProductProxy;
import br.stock.ms.dto.ContainerDTO;
import br.stock.ms.dto.ContainerResponseDTO;
import br.stock.ms.dto.ProductDTO;
import br.stock.ms.entity.Container;
import br.stock.ms.exceptions.NotFoundException;
import br.stock.ms.repository.ContainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ContainerRepository repository;

    @Autowired
    private ProductProxy productProxy;

    @Override
    public ContainerResponseDTO newOrder(ContainerDTO containerDTO) {
        validateProducts(containerDTO.getProducts());

        Container container = mapper.map(containerDTO, Container.class);

        Container save = repository.save(container);

        return mapper.map(save, ContainerResponseDTO.class);
    }

    @Override
    public ContainerResponseDTO getOrder(Integer id) {
        Optional<Container> response = repository.findById(id);
        Container localContainer = response.orElseThrow(() -> new NotFoundException("Order not found on local database"));

        return mapper.map(localContainer, ContainerResponseDTO.class);
    }

    @Override
    public List<ContainerResponseDTO> getAllOrders() {
        List<ContainerResponseDTO> response = new ArrayList<>();

        Iterable<Container> localOrders = repository.findAll();
        localOrders.forEach(order -> response.add(mapper.map(order, ContainerResponseDTO.class)));

        return response;
    }

    private void validateProducts(List<ProductDTO> products) {
        List<Integer> productIds = products.stream().map(p -> p.getProductId()).collect(Collectors.toList());

        productProxy.validateProducts(productIds);
    }

}
