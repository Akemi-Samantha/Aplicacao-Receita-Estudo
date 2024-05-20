package Projeto.CadastroPratos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class CadastroPratosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPratosApplication.class, args);
	}

}
