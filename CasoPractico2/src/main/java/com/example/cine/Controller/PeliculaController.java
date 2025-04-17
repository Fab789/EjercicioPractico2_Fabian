

package com.example.cine.Controller;

import com.example.cine.Domain.Pelicula;
import com.example.cine.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/peliculas")
@PreAuthorize("hasRole('ADMIN')")
public class PeliculaController {
  @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("peliculas", peliculaService.listar());
        return "peliculas/listar";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        service.guardar(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("pelicula", peliculaService.obtener(id));
        return "peliculas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return "redirect:/peliculas";
    }
}
