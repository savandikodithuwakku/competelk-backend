package lk.competelk.competelk_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CompetitionEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate deadline;
    private String registrationUrl;

    @ManyToOne(fetch = FetchType.LAZY) //Many editions can belong to one series.
    @JoinColumn(name = "series_id", nullable = false) //The edition table stores a foreign key named series_id
    private CompetitionSeries series;

    public CompetitionEdition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }

    public CompetitionSeries getSeries() {
        return series;
    }

    public void setSeries(CompetitionSeries series) {
        this.series = series;
    }
}