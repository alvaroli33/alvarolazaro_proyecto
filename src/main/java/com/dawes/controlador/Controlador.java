package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuariosVO;
import com.dawes.modelo.ViajesVO;
import com.dawes.servicio.ServicioRoles;
import com.dawes.servicio.ServicioUsuarioRol;
import com.dawes.servicio.ServicioUsuarios;
import com.dawes.servicio.ServicioViajes;
@Controller
public class Controlador {

	@Autowired
	ServicioUsuarios su;
	@Autowired
	ServicioUsuarioRol sur;
	@Autowired
	ServicioRoles sr;
	@Autowired
	ServicioViajes sv;
	
	@GetMapping("/index")
    public String index() {
        return "index";
    }
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	@GetMapping("/logout")
    public String logout() {
        return "logout";
    }
	@GetMapping("/403")
    public String p403() {
        return "403";
    }
	@GetMapping("/registrate")
    public String registrate(Model modelo) {
        modelo.addAttribute("usuario", new UsuariosVO());
        return "registrate";
    }
    @PostMapping("/registrate")
    public String persistir(@ModelAttribute UsuariosVO usuario,Model modelo) {
        BCryptPasswordEncoder encriptador=new BCryptPasswordEncoder();
        String contraseña = encriptador.encode(usuario.getPassword());
        usuario.setPassword(contraseña);
        su.save(usuario);
        sur.save(new UsuarioRolVO(0,usuario,sr.findById(2).get()));
        return "index";
    }
    @GetMapping("/crearpublicacion")
    public String publicacion(Model modelo) {
    	modelo.addAttribute("viaje", new ViajesVO());
        return "crearpublicacion";
    }
    @PostMapping("/crearpublicacion")
    public String crearpublicacion(@ModelAttribute ViajesVO viaje,Model modelo) {
    	Authentication auth = SecurityContextHolder
                 .getContext()
                 .getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        UsuariosVO usuario = su.findByUsername(userDetail.getUsername()).get();
        viaje.setUsuario(usuario);
        sv.save(viaje);
        return "redirect:/index";
    }
}
