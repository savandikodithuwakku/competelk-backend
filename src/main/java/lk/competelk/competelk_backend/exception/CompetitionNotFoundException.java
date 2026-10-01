package lk.competelk.competelk_backend.exception;

public class CompetitionNotFoundException extends RuntimeException {

    public CompetitionNotFoundException(Long id) {
        super("Competition not found with id: " + id); //calls the superclass constructor and gives it our error message.
    }
}