package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import Projeto.CadastroPratos.model.repository.CadastroPratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroPratosService {

    @Autowired
    private CadastroPratoRepository cadastroPratoRepository;

    public RetornoDto cadastrarPratos(CadastroPratosDto cadastroPratosDto) {
        CadastroPratoEntity cadastroPratoEntity = Converter.entityToCadastroDto(cadastroPratosDto);
        cadastroPratoRepository.save(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);


    }

    public RetornoDto atualizarPrato(Long id, CadastroPratosDto cadastroPratosDto) {
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id).get();
        cadastroPratoEntity.setPrato(cadastroPratosDto.getPrato());
        cadastroPratoEntity.setPais(cadastroPratosDto.getPais());
        cadastroPratoRepository.save(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);
    }

    public List<RetornoDto> listarPratos() {
        List<CadastroPratoEntity> cadastroPratoEntity = cadastroPratoRepository.findAll();
        return Converter.entityToRetornoDtoList(cadastroPratoEntity);
    }

    public RetornoDto buscarPrato(Long id) {
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id).get();
        return Converter.entityToRetornoDto(cadastroPratoEntity);
    }


    public RetornoDto deletarPrato(Long id) {
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id).get();
        cadastroPratoRepository.delete(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);
    }
}
