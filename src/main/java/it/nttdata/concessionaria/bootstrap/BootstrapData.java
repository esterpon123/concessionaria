package it.nttdata.concessionaria.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.concessionaria.models.Auto;
import it.nttdata.concessionaria.models.Concessionario;
import it.nttdata.concessionaria.models.Dipendenti;
import it.nttdata.concessionaria.models.Regione;
import it.nttdata.concessionaria.repository.AutoRepository;
import it.nttdata.concessionaria.repository.ConcessionarioRepository;
import it.nttdata.concessionaria.repository.DipendentiRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private AutoRepository autoRepository;
    private ConcessionarioRepository concessionarioRepository;
    private DipendentiRepository dipendentiRepository;

    public BootstrapData(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository,
            DipendentiRepository dipendentiRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
        this.dipendentiRepository = dipendentiRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Concessionario c1 = new Concessionario();
        c1.setNome("Auto4You");
        c1.setVia("Via Roma");
        c1.setRegione(Regione.LAZIO);
        c1.setCitta("Roma");

        Concessionario c2 = new Concessionario();
        c2.setNome("Concessionario Magno");
        c2.setVia("Via Padova");
        c2.setRegione(Regione.BASILICATA);
        c2.setCitta("Policoro");

        Auto a1 = new Auto();
        a1.setModello("Tipo");
        a1.setPrezzo((double) 15000);
        a1.setConcessionario(c1);

        Auto a2 = new Auto();
        a2.setModello("Panda");
        a2.setPrezzo((double) 13000);
        a2.setConcessionario(c1);

        Auto a3 = new Auto();
        a3.setModello("500");
        a3.setPrezzo((double) 10000);
        a3.setConcessionario(c2);

        Auto a4 = new Auto();
        a4.setModello("Punto");
        a4.setPrezzo((double) 19000);
        a4.setConcessionario(c2);

        Dipendenti d1 = new Dipendenti();
        d1.setNome("Mario");
        d1.setCognome("Rossi");
        d1.setEta(50);
        d1.setStipendio((double) 1500);
        d1.setConcessionario(c1);

        Dipendenti d2 = new Dipendenti();
        d2.setNome("Gianni");
        d2.setCognome("Bianchi");
        d2.setEta(30);
        d2.setStipendio((double) 1700);
        d2.setConcessionario(c2);
        
        c1.getListaDipendenti().add(d1);
        c2.getListaDipendenti().add(d2);

        c1.getListaAuto().add(a1);
        c1.getListaAuto().add(a2);
        c2.getListaAuto().add(a3);
        c2.getListaAuto().add(a4);

        //System.out.println(a1);

        concessionarioRepository.save(c1);
        concessionarioRepository.save(c2);

        autoRepository.save(a1);
        autoRepository.save(a2);
        autoRepository.save(a3);
        autoRepository.save(a4);


        dipendentiRepository.save(d1);
        dipendentiRepository.save(d2);

    }
    
}
