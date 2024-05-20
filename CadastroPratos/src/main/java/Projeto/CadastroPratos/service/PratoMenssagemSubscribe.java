package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class PratoMenssagemSubscribe {

    @RabbitListener(queues = "${rabbit.queue.name.cadastro}")
    public void receiveMessage(String jsonPayload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(jsonPayload, CadastroPratosDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbit.queue.name.atualizacao}")
    public void receiveMessageAtualizacao(String jsonPayload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(jsonPayload, CadastroPratosDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "${rabbit.queue.name.deletar}")
    public void receiveMessageDeletar(String jsonPayload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(jsonPayload, CadastroPratosDto.class);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

}
