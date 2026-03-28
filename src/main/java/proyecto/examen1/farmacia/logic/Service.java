package proyecto.examen1.farmacia.logic;

import proyecto.examen1.farmacia.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired private PacienteRepository pacientes;
    @Autowired private PacienteMedicamentoRepository pacienteMedicamentos;
    @Autowired private FarmaciaRepository farmacias;

    public Paciente buscarPaciente(String cedula) {
        Optional<Paciente> paciente = pacientes.findById(cedula);
        return paciente.orElse(null);
    }

    public List<Pacientemedicamento> medicamentosDePaciente(String cedula) {
        Paciente paciente = pacientes.findById(cedula).orElseThrow();
        return pacienteMedicamentos.findByPaciente(paciente);
    }

    public void registrarCompra(Integer pacienteMedicamentoId, Integer cantidad) {
        Pacientemedicamento pm = pacienteMedicamentos.findById(pacienteMedicamentoId).orElseThrow();
        pm.setDosisafavor(pm.getDosisafavor() + cantidad);
        pacienteMedicamentos.save(pm);
    }

    public String entregarRegalia(Integer pacienteMedicamentoId) {
        Pacientemedicamento pm = pacienteMedicamentos.findById(pacienteMedicamentoId).orElseThrow();
        int plan = pm.getMedicamento().getPlan();
        if (pm.getDosisafavor() < plan) {
            return "No hay dosis suficientes a favor para entregar";
        }
        pm.setDosisafavor(pm.getDosisafavor() - plan);
        pacienteMedicamentos.save(pm);
        return null;
    }

    public Farmacia farmaciaDeUsuario(String usuarioId) {
        return farmacias.findByUsuarioId(usuarioId);
    }
}