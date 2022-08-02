package com.cenfotec.ac.cr.examen2.controller;


import com.cenfotec.ac.cr.examen2.entities.Indice;
import com.cenfotec.ac.cr.examen2.entities.Jugador;
import com.cenfotec.ac.cr.examen2.service.IndiceService;
import com.cenfotec.ac.cr.examen2.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonaController {

    @Autowired
    IndiceService indiceService;
    @Autowired
    JugadorService personaService;

    @RequestMapping("/")
    private String homePage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/registrar")
    private String getRegistrarPage(Model model) {
        Jugador nueva = new Jugador();
        model.addAttribute("nueva", nueva);
        return "registrar";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    private String postRegistrarPage(Model model, Jugador nueva, BindingResult result) {
        float masa=(nueva.getPeso()/nueva.getEstatura());
        nueva.setMasaMuscular(masa);
        Indice ind =new Indice();
        ind.setFechaIngreso(LocalDate.now());
        ind.setMasaMuscular(masa);
        personaService.registrarPersona(nueva);
        List<Jugador> listaP=personaService.listarPersonas();
        for (Jugador p:listaP) {
            if (p.getNombre() == nueva.getNombre() && p.getPrimerApellido() == nueva.getPrimerApellido() && p.getSegundoApellido() == nueva.getSegundoApellido()) {
                ind.setIdUsuario(p.getId());
            }
        }
        indiceService.registrarIndice(ind);
        return "exito";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    private String getListPersonas(Jugador shop, Model model, String keyword) {
            if (keyword != null) {
                List<Jugador> list = personaService.getByKeyword(keyword);
                model.addAttribute("lista", list);
                return "lista";
            }
            model.addAttribute("lista", personaService.listarPersonas());
            return "lista";
        };

    @RequestMapping(value = "/verDetalle/{id}", method = RequestMethod.GET)
    public String irAVerDetalle(Model model, @PathVariable int id) {
        List<Jugador> list = personaService.getByKeyId(Long.valueOf(id));
        model.addAttribute("lista", list);
        return "verDetalle";
    }

    @RequestMapping(value = "/verMasa/{id}", method = RequestMethod.GET)
    public String irAVerMasa(Model model, @PathVariable int id) {
        List<Indice> list = indiceService.getByKeyId(Long.valueOf(id));
        model.addAttribute("lista", list);
        return "verMasaMuscular";
    }

    @RequestMapping(value = "/editar/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Jugador> persona = personaService.getById(id);
        if (persona.isPresent()){
            model.addAttribute("persona", persona);
            return "editar";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String guardarCambios(Jugador persona, BindingResult result,Model model, @PathVariable int id) {
        float masa=persona.getPeso()/persona.getEstatura();
        persona.setMasaMuscular(masa);
        Indice ind =new Indice();
        ind.setFechaIngreso(LocalDate.now());
        ind.setMasaMuscular(masa);
        ind.setIdUsuario(persona.getId());
        personaService.update(persona);
        indiceService.registrarIndice(ind);
        return "exito";
    }

    @RequestMapping(value = "/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        personaService.delete(id);
        return "exito";
    }

    @RequestMapping(value = {"/search"})
    public String search(Jugador shop, Model model, String keyword) {
        if (keyword != null) {
            List<Jugador> list = personaService.getByKeyword(keyword);
            model.addAttribute("lista", list);
            return "listaSearch";
        }
        return "lista";
    };
}
