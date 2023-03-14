package repository;

import model.ManoDeObra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManoDeObraRepository extends JpaRepository<ManoDeObra, Long> {
}
