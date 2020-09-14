package br.product.ms.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ProductIdsDTO {

    @NotEmpty(message = "ids are mandatory")
    List<Integer> ids;

}
