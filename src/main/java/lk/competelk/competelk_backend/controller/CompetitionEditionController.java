package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import lk.competelk.competelk_backend.dto.CreateCompetitionEditionRequest;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.service.CompetitionEditionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping
    public Page<CompetitionEditionResponse> getEditionsBySeries(
            @PathVariable Long seriesId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageable = PageRequest.of(
                Math.max(0, page),
                Math.max(1, Math.min(size, 100)),
                Sort.by(Sort.Direction.ASC, "id")
        );

        return editionService.getEditionsBySeries(seriesId, pageable);
    }
}