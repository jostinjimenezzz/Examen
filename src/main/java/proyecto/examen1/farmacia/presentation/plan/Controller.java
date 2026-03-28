package proyecto.examen1.farmacia.presentation.plan;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proyecto.examen1.farmacia.logic.Paciente;
import proyecto.examen1.farmacia.logic.Service;
import proyecto.examen1.farmacia.security.UserDetailsImp;

@org.springframework.stereotype.Controller("planController")
@RequestMapping("/presentation/plan")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/show")
    public String show(Model model, HttpSession session, @AuthenticationPrincipal UserDetailsImp userDetails) {

        String usuarioId = userDetails.getUsuario().getId();
        model.addAttribute("farmacia", service.farmaciaDeUsuario(usuarioId));

        String cedulaPaciente = (String) session.getAttribute("cedulaPaciente");
        if (cedulaPaciente != null) {
            cargarPaciente(model, cedulaPaciente);
        }

        model.addAttribute("cedula", cedulaPaciente != null ? cedulaPaciente : "");

        String errorRegalia = (String) session.getAttribute("errorRegalia");
        if (errorRegalia != null) {
            model.addAttribute("errorRegalia", errorRegalia);
            session.removeAttribute("errorRegalia");
        }

        return "presentation/plan/ViewPlan";
    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam("cedula") String cedula, HttpSession session) {
        session.setAttribute("cedulaPaciente", cedula);
        return "redirect:/presentation/plan/show";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam("pacienteMedicamentoId") Integer id, @RequestParam("cantidad") Integer cantidad, HttpSession session) {
        service.registrarCompra(id, cantidad);
        return "redirect:/presentation/plan/show";
    }

    @PostMapping("/entregar")
    public String entregar(@RequestParam("pacienteMedicamentoId") Integer id, HttpSession session) {
        String error = service.entregarRegalia(id);
        if (error != null) {
            session.setAttribute("errorRegalia", error);
        } else {
            session.removeAttribute("errorRegalia");
        }
        return "redirect:/presentation/plan/show";
    }

    private void cargarPaciente(Model model, String cedula) {
        Paciente paciente = service.buscarPaciente(cedula);
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
            model.addAttribute("medicamentos", service.medicamentosDePaciente(cedula));
        } else {
            model.addAttribute("pacienteNoEncontrado", true);
        }
    }
}
