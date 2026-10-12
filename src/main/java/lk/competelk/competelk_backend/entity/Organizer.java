package lk.competelk.competelk_backend.entity;

import jakarta.persistence.*;
import lk.competelk.competelk_backend.enums.VerificationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizers")
@Getter
@Setter
@NoArgsConstructor
public class Organizer {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String organizationName;

    private String websiteUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VerificationStatus verificationStatus =
            VerificationStatus.PENDING;
}