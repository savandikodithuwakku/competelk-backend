package lk.competelk.competelk_backend.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDate;

public record CreateCompetitionEditionRequest(

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Deadline is required")
        @Future(message = "Deadline must be in the future")
        LocalDate deadline,

        @NotBlank(message = "Registration URL is required")
        @URL(protocol = "https", message = "Registration URL must be a valid HTTPS URL")
        String registrationUrl

) {
}