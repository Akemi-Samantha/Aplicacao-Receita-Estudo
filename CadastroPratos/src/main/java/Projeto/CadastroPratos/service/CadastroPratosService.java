package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.exception.ErrorBadRequest;
import Projeto.CadastroPratos.exception.ErrorNotFound;
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
        if (cadastroPratosDto.getPrato() == null || cadastroPratosDto.getPais() == null) {
            throw new ErrorBadRequest("Os campos prato e pais são obrigatórios");
        }
        CadastroPratoEntity cadastroPratoEntity = Converter.entityToCadastroDto(cadastroPratosDto);
        cadastroPratoRepository.save(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);


    }

    public RetornoDto atualizarPrato(Long id, CadastroPratosDto cadastroPratosDto) {
        if (cadastroPratosDto.getPrato() == null || cadastroPratosDto.getPais() == null) {
            throw new ErrorBadRequest("Os campos prato e pais são obrigatórios");
        }
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id)
                .orElseThrow(() -> new ErrorNotFound("Id não encontrado"));
        cadastroPratoEntity.setPrato(cadastroPratosDto.getPrato());
        cadastroPratoEntity.setPais(cadastroPratosDto.getPais());
        cadastroPratoRepository.save(cadastroPratoEntity);
        return Converter.entityToRetornoDto(cadastroPratoEntity);
    }

    public List<RetornoDto> listarPratos() {
        List<CadastroPratoEntity> cadastroPratoEntity = cadastroPratoRepository.findAll();
        if (cadastroPratoEntity.isEmpty()) {
            throw new ErrorNotFound("Nenhum Id encontrado");
        }
        return Converter.entityToRetornoDtoList(cadastroPratoEntity);
    }

    public RetornoDto buscarPrato(Long id) {
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id)
                .orElseThrow(() -> new ErrorNotFound("Id não encontrado"));
        return Converter.entityToRetornoDto(cadastroPratoEntity);
    }


    public void deletarPrato(Long id) {
        CadastroPratoEntity cadastroPratoEntity = cadastroPratoRepository.findById(id)
                .orElseThrow(() -> new ErrorNotFound("Id não encontrado"));
        cadastroPratoRepository.delete(cadastroPratoEntity);
    }
}
