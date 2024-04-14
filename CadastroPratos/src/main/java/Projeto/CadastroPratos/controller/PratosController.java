package Projeto.CadastroPratos.controller;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.request.CadastroPratosRequest;
import Projeto.CadastroPratos.model.response.RetornoPratosResponse;
import Projeto.CadastroPratos.service.CadastroPratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prato")
public class PratosController {

    @Autowired
    private CadastroPratosService cadastroPratosService;

    public PratosController(CadastroPratosService cadastroPratosService) {
        this.cadastroPratosService = cadastroPratosService;
    }


    @PostMapping("/adicionarPrato")
    @ResponseStatus(HttpStatus.CREATED)
    public RetornoPratosResponse cadastrarPratos(@RequestBody CadastroPratosRequest cadastroPratosRequest){
        RetornoDto retornoDto = cadastroPratosService.cadastrarPratos(
                Converter.requestToDto(cadastroPratosRequest));
        return Converter.retornoPratosDtoToResponse(retornoDto);
    }


    @PutMapping("/atualizarPrato/{id}")
    public RetornoPratosResponse atualizarPrato(@PathVariable Long id, @RequestBody CadastroPratosRequest cadastroPratosRequest){
        RetornoDto retornoDto = cadastroPratosService.atualizarPrato(id, Converter.requestToDto(cadastroPratosRequest));
        return Converter.retornoPratosDtoToResponse(retornoDto);
    }

    @GetMapping("/listarPratos")
    public List<RetornoPratosResponse> listarPratos(){
        List<RetornoDto> retornoDto = cadastroPratosService.listarPratos();
        return Converter.retornoPratosDtoToResponseList(retornoDto);
    }

    @GetMapping("/buscarPrato/{id}")
    public RetornoPratosResponse buscarPrato(@PathVariable Long id){
        RetornoDto retornoDto = cadastroPratosService.buscarPrato(id);
        return Converter.retornoPratosDtoToResponse(retornoDto);
    }

    @DeleteMapping("/deletarPrato/{id}")
    public void deletarPrato(@PathVariable Long id){
         cadastroPratosService.deletarPrato(id);
    }



}
