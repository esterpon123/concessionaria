package it.nttdata.concessionaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.nttdata.concessionaria.repository.AutoRepository;

@Controller
public class ControllerAuto {
    
    private final AutoRepository autoRepository;

    public ControllerAuto(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // @RequestMapping("/automobili")
    // public String getAuto(Model model){
    //     model.addAttribute("automobili", autoRepository.findAll());
    //     return "auto";
    // }

    @RequestMapping("/listaauto")
    public String getAllAuto(Model model){
        model.addAttribute("listaautomobili", autoRepository.findAll());
        return "automob";
    }

}
