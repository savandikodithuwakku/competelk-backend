package lk.competelk.competelk_backend.service;

import lk.competelk.competelk_backend.entity.Competition;
import lk.competelk.competelk_backend.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import lk.competelk.competelk_backend.dto.CreateCompetitionRequest;
import lk.competelk.competelk_backend.exception.CompetitionNotFoundException;
import java.util.List;
import lk.competelk.competelk_backend.dto.CompetitionResponse;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<CompetitionResponse> getAllCompetitions() {
        return competitionRepository.findAll()
                .stream() //go through the competitions
                .map(this::mapToResponse)//convert each Competition into CompetitionResponse
                .toList();//collect the converted objects to a new list <CompetitionResponse>
    }

    public CompetitionResponse createCompetition(CreateCompetitionRequest request) {

        Competition competition = new Competition();// We just created a new empty Competition entity object. all fields has null

        competition.setTitle(request.getTitle()); //mapping from request DTO to entity then save
        competition.setDescription(request.getDescription());
        competition.setDeadline(request.getDeadline());

        Competition savedCompetition =
                competitionRepository.save(competition);

        return mapToResponse(savedCompetition);
    } //save=insert/update

    public CompetitionResponse getCompetitionById(Long id) {

        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new CompetitionNotFoundException(id));

        return mapToResponse(competition);
    }

    public void deleteCompetition(Long id) {

        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new CompetitionNotFoundException(id));

        competitionRepository.delete(competition);
    }

    public CompetitionResponse updateCompetition(
            Long id,
            CreateCompetitionRequest request) {

        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new CompetitionNotFoundException(id));

        competition.setTitle(request.getTitle());
        competition.setDescription(request.getDescription());
        competition.setDeadline(request.getDeadline());

        Competition updatedCompetition =
                competitionRepository.save(competition);

        return mapToResponse(updatedCompetition);
    }

    private CompetitionResponse mapToResponse(Competition competition) { //helper that CompetitionService uses internally
        return new CompetitionResponse(
                competition.getId(),
                competition.getTitle(),
                competition.getDescription(),
                competition.getDeadline()
        );
    }

}