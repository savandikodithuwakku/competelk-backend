package lk.competelk.competelk_backend.exception;

public class CompetitionEditionNotFoundException extends RuntimeException {

    public CompetitionEditionNotFoundException(Long id) {
        super("Competition edition not found with id: " + id);
    }
}