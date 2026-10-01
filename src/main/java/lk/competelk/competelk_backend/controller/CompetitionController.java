package lk.competelk.competelk_backend.controller;

import lk.competelk.competelk_backend.service.CompetitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lk.competelk.competelk_backend.dto.CreateCompetitionRequest;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import lk.competelk.competelk_backend.dto.CompetitionResponse;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<CompetitionResponse> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{id}")//api/competitions/1 here id=1
    public CompetitionResponse getCompetitionById(@PathVariable Long id) {
        return competitionService.getCompetitionById(id);
    }

    @PostMapping
    public CompetitionResponse createCompetition(
            @Valid @RequestBody CreateCompetitionRequest request) { //After converting the JSON into CreateCompetitionRequest, validate that object using the validation rules written on its fields.

        return competitionService.createCompetition(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
    }

    @PutMapping("/{id}")
    public CompetitionResponse updateCompetition(
            @PathVariable Long id,
            @Valid @RequestBody CreateCompetitionRequest request) {

        return competitionService.updateCompetition(id, request);
    }

}