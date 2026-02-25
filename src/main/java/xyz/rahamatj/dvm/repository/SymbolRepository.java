package xyz.rahamatj.dvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rahamatj.dvm.model.Symbol;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
}
