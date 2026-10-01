package lk.competelk.competelk_backend.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCompetitionRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be in the future")
    private LocalDate deadline;

    public CreateCompetitionRequest() {
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
}