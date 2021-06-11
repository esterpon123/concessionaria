package it.nttdata.concessionaria.repository;

import org.springframework.data.repository.CrudRepository;

import it.nttdata.concessionaria.models.Auto;

public interface AutoRepository extends CrudRepository<Auto, Long> {
    
}
