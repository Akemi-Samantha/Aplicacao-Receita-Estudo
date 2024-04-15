package Projeto.CadastroPratos.model.entitie;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cadastro_prato")
@Builder
public class CadastroPratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Prato")
    @Column(name = "Prato")
    private String prato;

    @JsonProperty("Pais")
    @Column(name ="Pais")
    private String pais;


}
