package it.nttdata.concessionaria.repository;

import org.springframework.data.repository.CrudRepository;

import it.nttdata.concessionaria.models.Concessionario;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {
    
}
