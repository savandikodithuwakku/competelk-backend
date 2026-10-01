package lk.competelk.competelk_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; //lets us control the HTTP response
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompetitionNotFoundException.class)//When a CompetitionNotFoundException occurs, use this method to handle it.
    public ResponseEntity<String> handleCompetitionNotFound(
            CompetitionNotFoundException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}