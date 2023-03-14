package repository;

import model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMecanicoRepository extends JpaRepository<Mecanico, Long> {
}
