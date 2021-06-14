package it.nttdata.concessionaria.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import it.nttdata.concessionaria.models.Auto;
import it.nttdata.concessionaria.repository.AutoRepository;
import it.nttdata.concessionaria.repository.ConcessionarioRepository;

@Controller
public class ControllerAuto {
    
    private final AutoRepository autoRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public ControllerAuto(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
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

    @GetMapping("/listaautoconcessionario/{nomeConcessionario}")
    public String getListaAutoConcessionario(Model model,@PathVariable("nomeConcessionario") String nomeConcessionario){
        ArrayList<Auto> listaAuto = (ArrayList<Auto>) autoRepository.findAll();
        ArrayList<Auto> listaAutoFiltrate = new ArrayList<Auto>();
        for(int i=0; i<listaAuto.size(); i++) {
            Auto a = listaAuto.get(i);
            if(a.getConcessionario().getNome() == nomeConcessionario){
                listaAutoFiltrate.add(a);
            }
        }
        model.addAttribute("listaautomobili", listaAutoFiltrate);
        return "automob";
    }

    @PostMapping("/addauto")
    //@ResponseBody
    public String addAuto(Auto auto){
        autoRepository.save(auto);
        return "redirect:/listaauto";
    }

    @GetMapping("/addauto")
    public String getForm(Model model){
        model.addAttribute("concessionarie", concessionarioRepository.findAll());
        return "formauto";
    }

}
