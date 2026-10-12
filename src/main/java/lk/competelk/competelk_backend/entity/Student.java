package lk.competelk.competelk_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId    //student profile shares its primary key with the corresponding user account. This avoids maintaining two unrelated identifiers for the same account.
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String fullName;

    private String institution;

    private String githubUrl;

    private String linkedinUrl;
}