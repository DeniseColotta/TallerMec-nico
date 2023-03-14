package repository;

import model.DetalleOrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleOrdenDeTrabajoRepository extends JpaRepository<DetalleOrdenDeTrabajo, Long> {
}
