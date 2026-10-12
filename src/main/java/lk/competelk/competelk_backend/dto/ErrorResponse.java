package lk.competelk.competelk_backend.dto;

public record ErrorResponse(
        int status,
        String message,
        String timestamp
) {
}