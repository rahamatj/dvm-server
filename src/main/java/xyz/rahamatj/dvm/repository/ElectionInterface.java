package xyz.rahamatj.dvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rahamatj.dvm.model.Election;

@Repository
public interface ElectionInterface extends JpaRepository<Election, Long> {
}
