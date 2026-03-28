package proyecto.examen1.farmacia.data;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.examen1.farmacia.logic.Pacientemedicamento;

public interface PacienteMedicamentoRepository extends JpaRepository<Pacientemedicamento, String> {
}
