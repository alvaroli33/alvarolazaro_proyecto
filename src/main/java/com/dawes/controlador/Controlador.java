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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String persistirregistrar(@ModelAttribute UsuariosVO usuario,Model modelo) {
       try {
    	   su.CrearUsuario(usuario);
    	   sur.save(new UsuarioRolVO(0,usuario,sr.findById(2).get()));
    	   return "login";
       }catch(Exception e) {
    	   modelo.addAttribute("ErrorUsuario",e.getMessage());
    	   return "registrate";
       }
    }
    @PostMapping("/editarusuario")
    public String editarusuario(@ModelAttribute UsuariosVO usuario,Model modelo) {
    	 BCryptPasswordEncoder encript=new BCryptPasswordEncoder();
         String contraseña = encript.encode(usuario.getPassword());
         usuario.setPassword(contraseña);
    	   su.save(usuario);
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
    @GetMapping("/perfil")
	public String perfil(Model modelo) {
		Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
       UserDetails userDetail = (UserDetails) auth.getPrincipal();
       UsuariosVO usuario = su.findByUsername(userDetail.getUsername()).get();
       modelo.addAttribute("usuario", usuario);
		return "perfil";
	}
    @GetMapping("/viaje")
	public String viaje(@RequestParam int idviajes,Model modelo) {
    	ViajesVO viaje=sv.findById(idviajes).get();
        modelo.addAttribute("viaje", viaje);
		return "viaje";
	}
    @GetMapping("/modificarviaje")
	public String modificarviaje(@RequestParam int idviajes,Model modelo) {
		ViajesVO viaje=sv.findById(idviajes).get();
		modelo.addAttribute("viaje",viaje);
		return "modificarviaje";
	}
    @GetMapping("/eliminarviaje")
	public String eliminarviaje(@RequestParam int idviajes,Model modelo) {
		sv.deleteById(idviajes);
		modelo.addAttribute("viaje",sv.findAll());
		return "index";
	}
    @GetMapping("/modificarusuario")
	public String modificarusuario(@RequestParam int idusuario,Model modelo) {
		UsuariosVO usuario=su.findById(idusuario).get();
		modelo.addAttribute("usuario",usuario);
		return "modificarusuario";
	}
    @GetMapping("/eliminarusuario")
	public String eliminarusuario(@RequestParam int idusuario,Model modelo) {
    	su.deleteById(idusuario);
		modelo.addAttribute("usuario",su.findAll());
		return "index";
	}
    @GetMapping("/aceptar")
	public String aceptar(@RequestParam int idusuario,Model modelo) {
    	UsuariosVO usuario=su.findById(idusuario).get();
		modelo.addAttribute("usuario",usuario);
		return "aceptar";
	}
    @GetMapping("/panel")
	public String panel(Model modelo) {
		modelo.addAttribute("usuario",su.findAll());
		modelo.addAttribute("viaje",sv.findAll());
		return "panel";
	}
    
}
