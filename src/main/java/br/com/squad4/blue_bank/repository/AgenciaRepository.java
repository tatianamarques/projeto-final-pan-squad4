package br.com.squad4.blue_bank.repository;

import br.com.squad4.blue_bank.model.Agencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    Page<Agencia> findByNumeroAgenciaContainingIgnoreCase(String numeroAgencia, Pageable paginacao);
    Optional<Agencia> findByNumeroAgencia(String numeroAgencia);
}
