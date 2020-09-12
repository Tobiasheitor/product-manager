package br.stock.ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerResponseDTO {

    private String id;
    private String trackerId;
    private LocalDateTime inputDate;
    private String company;
    private List<ProductDTO> products;

}
