package Projeto.CadastroPratos.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroRetornoPratosResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("Prato")
    private String prato;
    @JsonProperty("Pais")
    private String pais;

}
