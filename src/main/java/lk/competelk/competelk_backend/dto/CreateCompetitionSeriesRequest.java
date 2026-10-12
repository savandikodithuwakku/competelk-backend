package lk.competelk.competelk_backend.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCompetitionSeriesRequest(

        @NotBlank(message = "Series name is required")
        String name,

        @NotBlank(message = "Description is required")
        String description

) {
}