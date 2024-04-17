package Projeto.CadastroPratos.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PratoMessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKey;

    @Autowired
    public PratoMessageSender(RabbitTemplate rabbitTemplate,
                              @Value("${rabbit.exchange.name}") String exchangeName,
                              @Value("${rabbit.routing.key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public void enviarPratoCriado(String pratoNome) {
        String mensagem = "Novo prato cadastrado: " + pratoNome;
        rabbitTemplate.convertAndSend(exchangeName, routingKey, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }

    public void enviarPratoAtualizado(String pratoNome) {
        String mensagem = "Prato atualizado: " + pratoNome;
        rabbitTemplate.convertAndSend(exchangeName, routingKey, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }

    public void enviarPratoDeletado(String pratoNome) {
        String mensagem = "Prato deletado: " + pratoNome;
        rabbitTemplate.convertAndSend(exchangeName, routingKey, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }


}


