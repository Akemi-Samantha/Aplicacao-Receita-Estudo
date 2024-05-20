package Projeto.CadastroPratos.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroPratosDto {

    @JsonProperty("Prato")
    private String prato;

    @JsonProperty("Pais")
    private String pais;;


}
