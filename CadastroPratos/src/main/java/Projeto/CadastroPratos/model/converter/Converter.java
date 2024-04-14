package Projeto.CadastroPratos.model.converter;

import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import Projeto.CadastroPratos.model.dto.RetornoDto;
import Projeto.CadastroPratos.model.entitie.CadastroPratoEntity;
import Projeto.CadastroPratos.model.request.CadastroPratosRequest;
import Projeto.CadastroPratos.model.response.RetornoPratosResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public static CadastroPratosDto requestToDto(CadastroPratosRequest cadastroPratosRequest){
        return new CadastroPratosDto(
                  cadastroPratosRequest.getPrato()
                , cadastroPratosRequest.getPais());
    }

    public static RetornoPratosResponse retornoPratosDtoToResponse(RetornoDto retornoDto){
        return new RetornoPratosResponse(retornoDto.getId(), retornoDto.getPrato(), retornoDto.getPais());
    }


    public static RetornoDto entityToRetornoDto (CadastroPratoEntity cadastroPratoEntity){
        return new RetornoDto(cadastroPratoEntity.getId(), cadastroPratoEntity.getPrato(), cadastroPratoEntity.getPais());
    }

    public static CadastroPratoEntity entityToCadastroDto(CadastroPratosDto cadastroPratosDto){
        return new CadastroPratoEntity(null,cadastroPratosDto.getPrato(), cadastroPratosDto.getPais());
    }


    public static List<RetornoPratosResponse> retornoPratosDtoToResponseList(List<RetornoDto> retornoDto) {
        return retornoDto.stream().map(Converter::retornoPratosDtoToResponse).collect(Collectors.toList());
    }

    public static List<RetornoDto> entityToRetornoDtoList(List<CadastroPratoEntity> cadastroPratoEntity) {
        return cadastroPratoEntity.stream().map(Converter::entityToRetornoDto).collect(Collectors.toList());
    }

}
