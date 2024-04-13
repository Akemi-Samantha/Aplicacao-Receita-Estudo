package Projeto.CadastroPratos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoDto {

    private Long id;
    private String prato;
    private String pais;
}
