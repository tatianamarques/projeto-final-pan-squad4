package br.com.squad4.blue_bank.repository;

import br.com.squad4.blue_bank.model.Gerente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class GerenteDao {

    public List<Gerente> buildGerentes(){
        return Stream.of(
                new Gerente(123, "Eric Monné", "132-2", "Niterói"),
                new Gerente(234, "William Francisco", "123-7", "São Paulo"),
                new Gerente(345, "Tatiana Marques", "141-2", "Vila Velha"),
                new Gerente(456, "Ronald Corradi", "141-3", "Guarapari"),
                new Gerente(567, "Arion Mathias", "217-1", "Fortaleza")
        ).collect(Collectors.toList());
    }
}