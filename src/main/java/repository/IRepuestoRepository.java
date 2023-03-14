package repository;

import model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepuestoRepository extends JpaRepository<Repuesto, Long> {
}
