package proyecto.examen1.farmacia.data;
import proyecto.examen1.farmacia.logic.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, String> {
}
