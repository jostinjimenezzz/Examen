package proyecto.examen1.farmacia.data;
import proyecto.examen1.farmacia.logic.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaRepository extends JpaRepository<Farmacia, String> {
}
