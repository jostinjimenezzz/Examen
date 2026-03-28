package proyecto.examen1.farmacia.data;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.examen1.farmacia.logic.*;

public interface PacienteMedicamentoRepository extends JpaRepository<Pacientemedicamento, Integer> {
    List<Pacientemedicamento> findByPaciente(Paciente paciente);
}
