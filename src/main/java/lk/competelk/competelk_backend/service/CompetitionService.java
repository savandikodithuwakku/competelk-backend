package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.entity.Competition;
import lk.competelk.competelk_backend.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import lk.competelk.competelk_backend.dto.CreateCompetitionRequest;
import lk.competelk.competelk_backend.exception.CompetitionNotFoundException;
import java.util.List;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Competition createCompetition(CreateCompetitionRequest request) {

        Competition competition = new Competition();// We just created a new empty Competition entity object. all fields has null

        competition.setTitle(request.getTitle()); //mapping from DTO to entity then save
        competition.setDescription(request.getDescription());
        competition.setDeadline(request.getDeadline());

        return competitionRepository.save(competition);
    }
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new CompetitionNotFoundException(id));
    }
}