package lk.competelk.competelk_backend.dto;

import java.time.LocalDate;

public class CompetitionResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;

    public CompetitionResponse(
            Long id,
            String title,
            String description,
            LocalDate deadline) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
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
}