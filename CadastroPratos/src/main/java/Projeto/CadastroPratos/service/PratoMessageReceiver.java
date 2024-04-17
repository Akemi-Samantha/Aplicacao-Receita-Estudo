package Projeto.CadastroPratos.service;

import Projeto.CadastroPratos.model.dto.CadastroPratosDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PratoMessageReceiver {

    @Autowired
    private CadastroPratosService cadastroPratosService;

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void receiveMessage(String message) {

        System.out.println("Recebida a mensagem: " + message);

        if (message.startsWith("Novo prato cadastrado: ")) {
            String pratoNome = message.replace("Novo prato cadastrado: ", "");
            CadastroPratosDto cadastroPratosDto = new CadastroPratosDto();
            cadastroPratosDto.setPrato(pratoNome);
            cadastroPratosService.cadastrarPratos(cadastroPratosDto);

        } else if (message.startsWith("Prato atualizado: ")) {
            String[] parts = message.replace("Prato atualizado: ", "").split(";");
            Long id = Long.parseLong(parts[0]);
            CadastroPratosDto cadastroPratosDto = new CadastroPratosDto();
            cadastroPratosService.atualizarPrato(id, cadastroPratosDto);

        } else if (message.startsWith("Prato deletado: ")) {
            Long id = Long.parseLong(message.replace("Prato deletado: ", ""));
            cadastroPratosService.deletarPrato(id);
        }
    }
}
