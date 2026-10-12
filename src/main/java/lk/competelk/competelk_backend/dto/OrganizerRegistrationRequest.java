package lk.competelk.competelk_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record OrganizerRegistrationRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8, max = 72)
        String password,

        @NotBlank
        String organizationName,

        @URL(protocol = "https")
        String websiteUrl

) {
}