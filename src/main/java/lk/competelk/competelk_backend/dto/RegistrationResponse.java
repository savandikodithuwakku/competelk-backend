package lk.competelk.competelk_backend.dto;

import lk.competelk.competelk_backend.enums.Role;
import lk.competelk.competelk_backend.enums.VerificationStatus;

public record RegistrationResponse(
        Long id,
        String email,
        Role role,
        VerificationStatus verificationStatus
) {
}