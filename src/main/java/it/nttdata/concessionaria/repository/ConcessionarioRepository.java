package it.nttdata.concessionaria.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.nttdata.concessionaria.models.Concessionario;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {
    //select count(distinct regione) from concessionario
    @Query("SELECT COUNT(DISTINCT (C.regione)) FROM Concessionario C")
    Integer countRegion();
}
