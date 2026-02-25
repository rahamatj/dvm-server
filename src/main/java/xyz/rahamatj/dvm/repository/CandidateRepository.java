package xyz.rahamatj.dvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rahamatj.dvm.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
