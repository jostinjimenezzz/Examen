package proyecto.examen1.farmacia.presentation.login;

import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller("loginController")
public class Controller {

    @GetMapping("/login")
    public String login() {
        return "presentation/login/ViewLogin";
    }
}
