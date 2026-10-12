package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import lk.competelk.competelk_backend.dto.OrganizerRegistrationRequest;
import lk.competelk.competelk_backend.dto.RegistrationResponse;
import lk.competelk.competelk_backend.dto.StudentRegistrationRequest;
import lk.competelk.competelk_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/student")
    public ResponseEntity<RegistrationResponse> registerStudent(
            @Valid @RequestBody StudentRegistrationRequest request) {

        RegistrationResponse response =
                authService.registerStudent(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/register/organizer")
    public ResponseEntity<RegistrationResponse> registerOrganizer(
            @Valid @RequestBody OrganizerRegistrationRequest request) {

        RegistrationResponse response =
                authService.registerOrganizer(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}