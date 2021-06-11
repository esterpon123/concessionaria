package it.nttdata.concessionaria.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Concessionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String via;

    @NonNull
    private Regione regione;

    @NonNull
    @Size(min = 1)
    private String citta;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendenti> listaDipendenti;

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> listaAuto; 

    public Set<Auto> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(Set<Auto> listaAuto) {
        this.listaAuto = listaAuto;
    }

    public Set<Dipendenti> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(Set<Dipendenti> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    public Concessionario() {
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public Regione getRegione() {
        return regione;
    }
    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    

}
