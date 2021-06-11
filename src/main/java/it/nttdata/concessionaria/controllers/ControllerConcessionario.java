package it.nttdata.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.nttdata.concessionaria.repository.ConcessionarioRepository;

@Controller
public class ControllerConcessionario {
    
    private final ConcessionarioRepository concessionarioRepository;

    public ControllerConcessionario(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @RequestMapping("/concessionario")
    public String getConcessionario(Model model) {
        // Set<Concessionario> listaConcessionari = new HashSet<>();
        // listaConcessionari.addAll((Collection<? extends Concessionario>) concessionarioRepository.findAll());
        model.addAttribute("listaconcessionari", concessionarioRepository.findAll());
        return "concessionario";
    }

}
