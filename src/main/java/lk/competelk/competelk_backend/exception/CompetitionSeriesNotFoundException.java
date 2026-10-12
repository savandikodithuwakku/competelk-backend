package lk.competelk.competelk_backend.exception;

public class CompetitionSeriesNotFoundException extends RuntimeException {

    public CompetitionSeriesNotFoundException(Long id) {
        super("Competition series not found with id: " + id);
    }
}