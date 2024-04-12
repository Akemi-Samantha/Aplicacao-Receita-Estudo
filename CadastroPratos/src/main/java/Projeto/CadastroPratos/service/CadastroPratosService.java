package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import Projeto.CadastroPratos.model.repository.CadastroPratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPratosService {

    @Autowired
    private CadastroPratoRepository cadastroPratoRepository;

    public RetornoDto cadastrarPratos(CadastroPratosDto cadastroPratosDto) {
        CadastroPratoEntity cadastroPratoEntity = Converter.entityToCadastroDto(cadastroPratosDto);
        cadastroPratoRepository.save(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);


    }
}
