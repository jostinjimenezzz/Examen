package proyecto.examen1.farmacia.data;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.examen1.farmacia.logic.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
