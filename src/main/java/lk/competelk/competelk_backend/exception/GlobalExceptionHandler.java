package lk.competelk.competelk_backend.exception;

import java.time.OffsetDateTime;

import lk.competelk.competelk_backend.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompetitionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCompetitionNotFound(
            CompetitionNotFoundException exception) {

        ErrorResponse errorResponse = new ErrorResponse( //creating an object roughly containing


                HttpStatus.NOT_FOUND.value(),//status    = 404
                exception.getMessage(),//message   = "Competition not found with id: 99999"
                OffsetDateTime.now().toString() //timestamp = current date/time
        ); //Spring converts it to JSON

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}