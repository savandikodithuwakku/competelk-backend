package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.dto.CreateCompetitionEditionRequest;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.entity.CompetitionEdition;
import lk.competelk.competelk_backend.entity.CompetitionSeries;
import lk.competelk.competelk_backend.exception.CompetitionEditionNotFoundException;
import lk.competelk.competelk_backend.exception.CompetitionSeriesNotFoundException;
import lk.competelk.competelk_backend.repository.CompetitionEditionRepository;
import lk.competelk.competelk_backend.repository.CompetitionSeriesRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompetitionEditionService {

    private final CompetitionEditionRepository editionRepository;
    private final CompetitionSeriesRepository seriesRepository;

    @Transactional
    public CompetitionEditionResponse createEdition(
            Long seriesId,
            CreateCompetitionEditionRequest request) {

        CompetitionSeries series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new CompetitionSeriesNotFoundException(seriesId));

        CompetitionEdition edition = new CompetitionEdition();

        edition.setTitle(request.title());
        edition.setDescription(request.description());
        edition.setDeadline(request.deadline());
        edition.setRegistrationUrl(request.registrationUrl());
        edition.setSeries(series);

        CompetitionEdition savedEdition = editionRepository.save(edition);

        return mapToResponse(savedEdition);
    }

    @Transactional(readOnly = true)
    public Page<CompetitionEditionResponse> getAllEditions(Pageable pageable) {

        return editionRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Transactional(readOnly = true)
    public CompetitionEditionResponse getEditionById(Long id) {

        CompetitionEdition edition = editionRepository.findById(id)
                .orElseThrow(() -> new CompetitionEditionNotFoundException(id));

        return mapToResponse(edition);
    }

    @Transactional(readOnly = true)
    public Page<CompetitionEditionResponse> getEditionsBySeries(
            Long seriesId,
            Pageable pageable) {

        if (!seriesRepository.existsById(seriesId)) {
            throw new CompetitionSeriesNotFoundException(seriesId);
        }

        return editionRepository.findBySeriesId(seriesId, pageable)
                .map(this::mapToResponse);
    }

    private CompetitionEditionResponse mapToResponse(
            CompetitionEdition edition) {

        return new CompetitionEditionResponse(
                edition.getId(),
                edition.getSeries().getId(),
                edition.getTitle(),
                edition.getDescription(),
                edition.getDeadline(),
                edition.getRegistrationUrl()
        );
    }
}