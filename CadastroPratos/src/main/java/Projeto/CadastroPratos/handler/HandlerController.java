package Projeto.CadastroPratos.handler;

import Projeto.CadastroPratos.exception.ErrorBadRequest;
import Projeto.CadastroPratos.exception.ErrorNotFound;
import Projeto.CadastroPratos.exception.ResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerController {

    @ExceptionHandler(ErrorBadRequest.class)
    public ResponseEntity<ResponseExceptions> handleErrorBadRequest(ErrorBadRequest ex) {
        return new ResponseEntity<>(
                ResponseExceptions.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception")
                        .detalhes(ex.getMessage())
                        .msgdev(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorNotFound.class)
    public ResponseEntity<ResponseExceptions> handleErrorNotFound(ErrorNotFound ex) {
        return new ResponseEntity<>(
                ResponseExceptions.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .titulo("Not Found Exception")
                        .detalhes(ex.getMessage())
                        .msgdev(ex.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);

    }
}
