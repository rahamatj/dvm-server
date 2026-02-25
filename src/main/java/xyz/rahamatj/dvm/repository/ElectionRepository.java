package xyz.rahamatj.dvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rahamatj.dvm.model.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
