package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import lk.competelk.competelk_backend.dto.CreateCompetitionEditionRequest;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.service.CompetitionEditionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/series/{seriesId}/editions")
public class CompetitionEditionController {

    private final CompetitionEditionService editionService;

    public CompetitionEditionController(CompetitionEditionService editionService) {
        this.editionService = editionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionEditionResponse createEdition(
            @PathVariable Long seriesId,
            @Valid @RequestBody CreateCompetitionEditionRequest request) {

        return editionService.createEdition(seriesId, request);
    }
}