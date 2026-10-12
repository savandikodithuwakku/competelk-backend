package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.dto.CreateCompetitionEditionRequest;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.entity.CompetitionEdition;
import lk.competelk.competelk_backend.entity.CompetitionSeries;
import lk.competelk.competelk_backend.exception.CompetitionSeriesNotFoundException;
import lk.competelk.competelk_backend.repository.CompetitionEditionRepository;
import lk.competelk.competelk_backend.repository.CompetitionSeriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompetitionEditionService {

    private final CompetitionEditionRepository editionRepository;
    private final CompetitionSeriesRepository seriesRepository;

    public CompetitionEditionService(
            CompetitionEditionRepository editionRepository,
            CompetitionSeriesRepository seriesRepository) {

        this.editionRepository = editionRepository;
        this.seriesRepository = seriesRepository;
    }

    @Transactional
    public CompetitionEditionResponse createEdition(
            Long seriesId,
            CreateCompetitionEditionRequest request) {

        CompetitionSeries series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new CompetitionSeriesNotFoundException(seriesId));

        CompetitionEdition edition = new CompetitionEdition();

        edition.setTitle(request.getTitle());
        edition.setDescription(request.getDescription());
        edition.setDeadline(request.getDeadline());
        edition.setRegistrationUrl(request.getRegistrationUrl());
        edition.setSeries(series);

        CompetitionEdition savedEdition = editionRepository.save(edition);

        return new CompetitionEditionResponse(
                savedEdition.getId(),
                savedEdition.getSeries().getId(),
                savedEdition.getTitle(),
                savedEdition.getDescription(),
                savedEdition.getDeadline(),
                savedEdition.getRegistrationUrl()
        );
    }
}