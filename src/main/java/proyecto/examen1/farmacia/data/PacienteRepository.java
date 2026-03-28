package proyecto.examen1.farmacia.data;
import proyecto.examen1.farmacia.logic.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
