package proyecto.examen1.farmacia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import proyecto.practica.documentos.data.UsuarioRepository;
import proyecto.practica.documentos.logic.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usr = usuarioRepository.findById(username).get();
            return new UserDetailsImp(usr);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
    }
}
