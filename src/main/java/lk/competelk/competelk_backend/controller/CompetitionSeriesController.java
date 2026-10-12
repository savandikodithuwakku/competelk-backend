package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import lk.competelk.competelk_backend.dto.CreateCompetitionSeriesRequest;
import lk.competelk.competelk_backend.dto.CompetitionSeriesResponse;
import lk.competelk.competelk_backend.service.CompetitionSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/series")
public class CompetitionSeriesController {

    private final CompetitionSeriesService seriesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionSeriesResponse createSeries(
            @Valid @RequestBody CreateCompetitionSeriesRequest request) {

        return seriesService.createSeries(request);
    }
}