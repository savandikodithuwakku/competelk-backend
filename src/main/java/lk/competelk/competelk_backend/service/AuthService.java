package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.dto.OrganizerRegistrationRequest;
import lk.competelk.competelk_backend.dto.RegistrationResponse;
import lk.competelk.competelk_backend.dto.StudentRegistrationRequest;
import lk.competelk.competelk_backend.entity.Organizer;
import lk.competelk.competelk_backend.entity.Student;
import lk.competelk.competelk_backend.entity.User;
import lk.competelk.competelk_backend.enums.Role;
import lk.competelk.competelk_backend.enums.VerificationStatus;
import lk.competelk.competelk_backend.exception.EmailAlreadyExistsException;
import lk.competelk.competelk_backend.repository.OrganizerRepository;
import lk.competelk.competelk_backend.repository.StudentRepository;
import lk.competelk.competelk_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final OrganizerRepository organizerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional //ensures that creating the user account and its profile happens as one database operation.
    // If saving the profile fails, the account creation is rolled back.
    public RegistrationResponse registerStudent(
            StudentRegistrationRequest request) {

        String email = normalizeEmail(request.email());
        validateEmailAvailability(email);

        User user = createUser(
                email,
                request.password(),
                Role.STUDENT
        );

        Student student = new Student();
        student.setUser(user);
        student.setFullName(request.fullName().trim());
        student.setInstitution(request.institution());

        studentRepository.save(student);

        return new RegistrationResponse(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                null
        );
    }

    @Transactional
    public RegistrationResponse registerOrganizer(
            OrganizerRegistrationRequest request) {

        String email = normalizeEmail(request.email());
        validateEmailAvailability(email);

        User user = createUser(
                email,
                request.password(),
                Role.ORGANIZER
        );

        Organizer organizer = new Organizer();
        organizer.setUser(user);
        organizer.setOrganizationName(
                request.organizationName().trim()
        );
        organizer.setWebsiteUrl(request.websiteUrl());
        organizer.setVerificationStatus(
                VerificationStatus.PENDING
        );

        organizerRepository.save(organizer);

        return new RegistrationResponse(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                organizer.getVerificationStatus()
        );
    }

    private User createUser(
            String email,
            String password,
            Role role) {

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setRole(role);

        return userRepository.save(user);
    }

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    private void validateEmailAvailability(String email) {

        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }
    }
}