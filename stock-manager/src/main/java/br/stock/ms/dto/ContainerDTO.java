package br.stock.ms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerDTO {

    @NotNull
    @NotEmpty
    private String trackerId;

    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime inputDate;

    private String company;
    private List<ProductDTO> products;

}
