package Projeto.CadastroPratos.model.entitie;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_market_data")
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
