package lk.competelk.competelk_backend.repository;

import lk.competelk.competelk_backend.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository; //interface

//This repository(interface) manages Competition entities, and the ID type of Competition is Long

public interface CompetitionRepository
        extends JpaRepository<Competition, Long> {//Competition is the entity managed by the repository, and Competition objects there and Long is the datatype of its primary key.
}
