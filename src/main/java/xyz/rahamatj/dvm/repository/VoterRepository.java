package xyz.rahamatj.dvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rahamatj.dvm.model.Voter;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    boolean existsByNid(String nid);

    Voter findByNid(String nid);
}
