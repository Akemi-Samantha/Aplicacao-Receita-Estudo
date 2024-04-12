package Projeto.CadastroPratos.model.repository;

import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroPratoRepository extends JpaRepository<CadastroPratoEntity, Long> {
}
