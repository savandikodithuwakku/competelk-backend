package lk.competelk.competelk_backend.repository;

import lk.competelk.competelk_backend.entity.CompetitionEdition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionEditionRepository
        extends JpaRepository<CompetitionEdition, Long> {

    Page<CompetitionEdition> findBySeriesId(
            Long seriesId,
            Pageable pageable
    );
    //findBySeriesId — find editions whose related series has the given ID.
    //Pageable — specifies page number, page size, and sorting.
    // Page<CompetitionEdition> — contains the results plus pagination information.
}