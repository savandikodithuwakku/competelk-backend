
package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lk.competelk.competelk_backend.dto.CreateCompetitionEditionRequest;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.service.CompetitionEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/series/{seriesId}/editions")
public class CompetitionEditionController {

    private final CompetitionEditionService editionService;

    // Creates an edition belonging to an existing competition series.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionEditionResponse createEdition(
            @PathVariable Long seriesId,
            @Valid @RequestBody CreateCompetitionEditionRequest request) {

        return editionService.createEdition(seriesId, request);
    }

    // Returns editions belonging to the requested series.
    @GetMapping
    public Page<CompetitionEditionResponse> getEditionsBySeries(
            @PathVariable Long seriesId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) int size) {

        PageRequest pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.ASC, "id")
        );

        return editionService.getEditionsBySeries(seriesId, pageable);
    }
}
