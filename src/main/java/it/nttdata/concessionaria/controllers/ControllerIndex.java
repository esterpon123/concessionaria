package it.nttdata.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.nttdata.concessionaria.repository.ConcessionarioRepository;

@Controller
public class ControllerIndex {
    
    private final ConcessionarioRepository concessionarioRepository;

    public ControllerIndex(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("numeroRegioni", concessionarioRepository.countRegion());
        return "index";
    }

}
