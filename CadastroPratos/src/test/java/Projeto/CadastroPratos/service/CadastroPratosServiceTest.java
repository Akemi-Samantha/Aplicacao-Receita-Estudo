package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.exception.ErrorBadRequest;
import Projeto.CadastroPratos.exception.ErrorNotFound;
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
import java.util.Optional;

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
        Mockito.when(cadastroPratoRepository.findById(1L)).thenReturn(Optional.ofNullable((cadastroPratoEntity)));
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
        cadastroPratosService.deletarPrato(1L);
    }

    @Test
    void cadastrarPratosErro() {
        cadastroPratosDto.setPrato(null);
        cadastroPratosDto.setPais(null);
        assertThrows(ErrorBadRequest.class, () -> cadastroPratosService.cadastrarPratos(cadastroPratosDto));
    }

    @Test
    void atualizarPratoErroNull() {
        cadastroPratosDto.setPrato(null);
        cadastroPratosDto.setPais(null);
        assertThrows(ErrorBadRequest.class, () -> cadastroPratosService.atualizarPrato(1L, cadastroPratosDto));
    }

    @Test
    void atualizarPratoErroNotFound() {
        Mockito.when(cadastroPratoRepository.findById(2L)).thenReturn(java.util.Optional.empty());
        assertThrows(ErrorNotFound.class, () -> cadastroPratosService.atualizarPrato(2L, cadastroPratosDto));
    }

    @Test
    void listarPratosErro() {
        Mockito.when(cadastroPratoRepository.findAll()).thenReturn(List.of());
        assertThrows(ErrorNotFound.class, () -> cadastroPratosService.listarPratos());
    }

    @Test
    void buscarPratoErro() {
        Mockito.when(cadastroPratoRepository.findById(2L)).thenReturn(java.util.Optional.empty());
        assertThrows(ErrorNotFound.class, () -> cadastroPratosService.buscarPrato(2L));
    }

    @Test
    void deletarPratoErro() {
        Mockito.when(cadastroPratoRepository.findById(2L)).thenReturn(java.util.Optional.empty());
        assertThrows(ErrorNotFound.class, () -> cadastroPratosService.deletarPrato(2L));
    }
}