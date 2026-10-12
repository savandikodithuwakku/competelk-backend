package lk.competelk.competelk_backend.dto;

import java.time.LocalDate;

public record CompetitionEditionResponse(
        Long id,
        Long seriesId,
        String title,
        String description,
        LocalDate deadline,
        String registrationUrl
) {
}