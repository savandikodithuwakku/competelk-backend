package lk.competelk.competelk_backend.controller;

import jakarta.validation.Valid;
import lk.competelk.competelk_backend.dto.CreateCompetitionSeriesRequest;
import lk.competelk.competelk_backend.dto.CompetitionSeriesResponse;
import lk.competelk.competelk_backend.service.CompetitionSeriesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/series")
public class CompetitionSeriesController {

    private final CompetitionSeriesService seriesService;

    public CompetitionSeriesController(
            CompetitionSeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping
    public CompetitionSeriesResponse createSeries(
            @Valid @RequestBody CreateCompetitionSeriesRequest request) {

        return seriesService.createSeries(request);
    }
}