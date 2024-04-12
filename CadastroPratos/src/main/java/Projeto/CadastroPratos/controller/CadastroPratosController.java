package Projeto.CadastroPratos.controller;

import Projeto.CadastroPratos.model.converter.Converter;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.request.CadastroPratosRequest;
import Projeto.CadastroPratos.model.response.CadastroRetornoPratosResponse;
import Projeto.CadastroPratos.service.CadastroPratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CadastroPratos")
public class CadastroPratosController {

    @Autowired
    private CadastroPratosService cadastroPratosService;


    @PostMapping("/cadastrarPratos")
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroRetornoPratosResponse cadastrarPratos(@RequestBody CadastroPratosRequest cadastroPratosRequest){
        RetornoDto retornoDto = cadastroPratosService.cadastrarPratos(
                Converter.requestToDto(cadastroPratosRequest));
        return Converter.cadastroRetornoPratosDtoToResponse(retornoDto);
    }

}
