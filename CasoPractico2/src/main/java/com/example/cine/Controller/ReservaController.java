

package com.example.cine.Controller;

import com.example.cine.Domain.Funcion;
import com.example.cine.Service.FuncionService;
import com.example.cine.Domain.Pelicula;
import com.example.cine.Service.PeliculaService;
import com.example.cine.Domain.Reserva;
import com.example.cine.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


 @Controller
@RequestMapping("/reservas")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private UsuarioService usuarioService;
    
     @GetMapping
    public String cartelera(Model model) {
        model.addAttribute("funciones", funcionService.listar());
        return "reservas/cartelera";
    }

    @PostMapping("/realizar")
    public String realizarReserva(@ModelAttribute Reserva reserva, Principal principal) {
        Usuario usuario = usuarioService.buscarPorUsername(principal.getName());
        reserva.setUsuario(usuario);
        reservaService.reservar(reserva);
        return "redirect:/reservas/mis-reservas";
    }

    @GetMapping("/mis-reservas")
    public String misReservas(Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarPorUsername(principal.getName());
        model.addAttribute("reservas", reservaService.listarPorUsuario(usuario));
        return "reservas/mis_reservas";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelar(@PathVariable Long id) {
        reservaService.cancelar(id);
        return "redirect:/reservas/mis-reservas";
    }


}
