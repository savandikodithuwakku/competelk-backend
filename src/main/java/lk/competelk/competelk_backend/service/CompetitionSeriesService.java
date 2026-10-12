package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.dto.CreateCompetitionSeriesRequest;
import lk.competelk.competelk_backend.dto.CompetitionSeriesResponse;
import lk.competelk.competelk_backend.entity.CompetitionSeries;
import lk.competelk.competelk_backend.repository.CompetitionSeriesRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompetitionSeriesService {

    private final CompetitionSeriesRepository seriesRepository;

    @Transactional
    public CompetitionSeriesResponse createSeries(
            CreateCompetitionSeriesRequest request) {

        CompetitionSeries series = new CompetitionSeries();

        series.setName(request.name());
        series.setDescription(request.description());

        CompetitionSeries savedSeries = seriesRepository.save(series);

        return new CompetitionSeriesResponse(
                savedSeries.getId(),
                savedSeries.getName(),
                savedSeries.getDescription()
        );
    }
}