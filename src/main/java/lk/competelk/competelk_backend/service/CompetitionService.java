package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.entity.Competition;
import lk.competelk.competelk_backend.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> getAllCompetitions() { //return list(objects) of competitons
        return competitionRepository.findAll();
    }
}