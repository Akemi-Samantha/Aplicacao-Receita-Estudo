package Projeto.CadastroPratos.controller;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import Projeto.CadastroPratos.model.request.CadastroPratosRequest;
import Projeto.CadastroPratos.model.response.RetornoPratosResponse;
import Projeto.CadastroPratos.service.CadastroPratosService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PratosControllerTest {

    private PratosController pratosController;

    @Mock
    private CadastroPratosService cadastroPratosService;

    private CadastroPratoEntity cadastroPratoEntity;

    @BeforeEach
    public void setUp() {
        pratosController = new PratosController(cadastroPratosService);
        CadastroPratosRequest cadastroPratosRequest = new CadastroPratosRequest();
        cadastroPratosRequest.setPrato("Feijoada");
        cadastroPratosRequest.setPais("Brasil");

        cadastroPratoEntity = new CadastroPratoEntity();
        cadastroPratoEntity.setId(1L);
        cadastroPratoEntity.setPrato("Feijoada");
        cadastroPratoEntity.setPais("Brasil");


    }


    @Test
    void cadastrarPratosSucesso() {
        Mockito.when(cadastroPratosService.cadastrarPratos(Converter.requestToDto(new CadastroPratosRequest()))).thenReturn(Converter.entityToRetornoDto(cadastroPratoEntity));
        RetornoPratosResponse retornoPratosResponse = pratosController.cadastrarPratos(new CadastroPratosRequest());
        Assertions.assertNotNull(retornoPratosResponse);
        Assertions.assertEquals(cadastroPratoEntity.getId(), retornoPratosResponse.getId());
        Assertions.assertEquals(cadastroPratoEntity.getPrato(), retornoPratosResponse.getPrato());
        Assertions.assertEquals(cadastroPratoEntity.getPais(), retornoPratosResponse.getPais());

    }

    @Test
    void atualizarPrato() {
        Mockito.when(cadastroPratosService.atualizarPrato(1L, Converter.requestToDto(new CadastroPratosRequest()))).thenReturn(Converter.entityToRetornoDto(cadastroPratoEntity));
        RetornoPratosResponse retornoPratosResponse = pratosController.atualizarPrato(1L, new CadastroPratosRequest());
        Assertions.assertNotNull(retornoPratosResponse);
        Assertions.assertEquals(cadastroPratoEntity.getId(), retornoPratosResponse.getId());
        Assertions.assertEquals(cadastroPratoEntity.getPrato(), retornoPratosResponse.getPrato());
        Assertions.assertEquals(cadastroPratoEntity.getPais(), retornoPratosResponse.getPais());

    }

    @Test
    void listarPratos() {
        List<CadastroPratoEntity> cadastroPratoEntityList = new ArrayList<>();
        cadastroPratoEntityList.add(cadastroPratoEntity);
        Mockito.when(cadastroPratosService.listarPratos()).thenReturn(Converter.entityToRetornoDtoList(cadastroPratoEntityList));
        List<RetornoPratosResponse> retornoPratosResponseList = pratosController.listarPratos();
        Assertions.assertNotNull(retornoPratosResponseList);
        Assertions.assertEquals(cadastroPratoEntity.getId(), retornoPratosResponseList.get(0).getId());
        Assertions.assertEquals(cadastroPratoEntity.getPrato(), retornoPratosResponseList.get(0).getPrato());
        Assertions.assertEquals(cadastroPratoEntity.getPais(), retornoPratosResponseList.get(0).getPais());

    }

    @Test
    void buscarPrato() {
        Mockito.when(cadastroPratosService.buscarPrato(1L)).thenReturn(Converter.entityToRetornoDto(cadastroPratoEntity));
        RetornoPratosResponse retornoPratosResponse = pratosController.buscarPrato(1L);
        Assertions.assertNotNull(retornoPratosResponse);
        Assertions.assertEquals(cadastroPratoEntity.getId(), retornoPratosResponse.getId());
        Assertions.assertEquals(cadastroPratoEntity.getPrato(), retornoPratosResponse.getPrato());
        Assertions.assertEquals(cadastroPratoEntity.getPais(), retornoPratosResponse.getPais());
    }

    @Test
    void deletarPrato() {
        pratosController.deletarPrato(1L);
        Mockito.verify(cadastroPratosService, Mockito.times(1)).deletarPrato(1L);

    }


}