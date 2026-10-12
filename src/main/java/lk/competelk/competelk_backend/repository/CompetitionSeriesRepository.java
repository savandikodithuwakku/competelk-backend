package lk.competelk.competelk_backend.repository;

import lk.competelk.competelk_backend.entity.CompetitionSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionSeriesRepository
        extends JpaRepository<CompetitionSeries, Long> {
}