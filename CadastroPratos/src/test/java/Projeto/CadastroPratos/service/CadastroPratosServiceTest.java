package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import Projeto.CadastroPratos.model.repository.CadastroPratoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CadastroPratosServiceTest {

    @Mock
    private CadastroPratoRepository cadastroPratoRepository;

    @InjectMocks
    private CadastroPratosService cadastroPratosService;

    private CadastroPratoEntity cadastroPratoEntity;

    private CadastroPratosDto cadastroPratosDto;

    @BeforeEach
    void setUp() {

        cadastroPratosDto = new CadastroPratosDto();
        cadastroPratosDto.setPrato("Feijoada");
        cadastroPratosDto.setPais("Brasil");


        cadastroPratoEntity = new CadastroPratoEntity();
        cadastroPratoEntity.setId(1L);
        cadastroPratoEntity.setPrato("Feijoada");
        cadastroPratoEntity.setPais("Brasil");

    }

    @Test
    void cadastrarPratos() {
        Mockito.when(cadastroPratoRepository.save(Converter.entityToCadastroDto(cadastroPratosDto))).thenReturn(cadastroPratoEntity);
        CadastroPratoEntity cadastroPratoEntity = Converter.entityToCadastroDto(cadastroPratosDto);
        RetornoDto retornoDto = Converter.entityToRetornoDto(cadastroPratoEntity);
        RetornoDto result = cadastroPratosService.cadastrarPratos(cadastroPratosDto);
        assertEquals(retornoDto, result);
    }

    @Test
    void atualizarPrato() {
        Mockito.when(cadastroPratoRepository.findById(1L)).thenReturn(java.util.Optional.of(cadastroPratoEntity));
        Mockito.when(cadastroPratoRepository.save(cadastroPratoEntity)).thenReturn(cadastroPratoEntity);
        RetornoDto retornoDto = Converter.entityToRetornoDto(cadastroPratoEntity);
        RetornoDto result = cadastroPratosService.atualizarPrato(1L, cadastroPratosDto);
        assertEquals(retornoDto, result);
    }

    @Test
    void listarPratos() {
        Mockito.when(cadastroPratoRepository.findAll()).thenReturn(List.of(cadastroPratoEntity));
        RetornoDto retornoDto = Converter.entityToRetornoDto(cadastroPratoEntity);
        RetornoDto result = cadastroPratosService.listarPratos().get(0);
        assertEquals(retornoDto, result);
    }

    @Test
    void buscarPrato() {
        Mockito.when(cadastroPratoRepository.findById(1L)).thenReturn(java.util.Optional.of(cadastroPratoEntity));
        RetornoDto retornoDto = Converter.entityToRetornoDto(cadastroPratoEntity);
        RetornoDto result = cadastroPratosService.buscarPrato(1L);
        assertEquals(retornoDto, result);
    }

    @Test
    void deletarPrato() {
        Mockito.when(cadastroPratoRepository.findById(1L)).thenReturn(java.util.Optional.of(cadastroPratoEntity));
        RetornoDto retornoDto = Converter.entityToRetornoDto(cadastroPratoEntity);
        RetornoDto result = cadastroPratosService.deletarPrato(1L);
        assertEquals(retornoDto, result);
    }
}