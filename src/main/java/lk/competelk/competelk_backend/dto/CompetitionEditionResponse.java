package lk.competelk.competelk_backend.dto;

import java.time.LocalDate;

public class CompetitionEditionResponse {

    private final Long id;
    private final Long seriesId;
    private final String title;
    private final String description;
    private final LocalDate deadline;
    private final String registrationUrl;

    public CompetitionEditionResponse(
            Long id,
            Long seriesId,
            String title,
            String description,
            LocalDate deadline,
            String registrationUrl) {

        this.id = id;
        this.seriesId = seriesId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.registrationUrl = registrationUrl;
    }

    public Long getId() {
        return id;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getRegistrationUrl() {
        return registrationUrl;
    }
}