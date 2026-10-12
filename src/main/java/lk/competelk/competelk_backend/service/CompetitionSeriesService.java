package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.dto.CreateCompetitionSeriesRequest;
import lk.competelk.competelk_backend.dto.CompetitionSeriesResponse;
import lk.competelk.competelk_backend.entity.CompetitionSeries;
import lk.competelk.competelk_backend.repository.CompetitionSeriesRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetitionSeriesService {

    private final CompetitionSeriesRepository seriesRepository;

    public CompetitionSeriesService(
            CompetitionSeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public CompetitionSeriesResponse createSeries(
            CreateCompetitionSeriesRequest request) {

        CompetitionSeries series = new CompetitionSeries();

        series.setName(request.getName());
        series.setDescription(request.getDescription());

        CompetitionSeries savedSeries = seriesRepository.save(series);

        return new CompetitionSeriesResponse(
                savedSeries.getId(),
                savedSeries.getName(),
                savedSeries.getDescription()
        );
    }
}