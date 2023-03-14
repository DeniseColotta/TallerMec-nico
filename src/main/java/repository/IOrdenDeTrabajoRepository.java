package repository;

import model.OrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajo, Long> {
}
