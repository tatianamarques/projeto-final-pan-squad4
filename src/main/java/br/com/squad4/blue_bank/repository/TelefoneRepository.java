package br.com.squad4.blue_bank.repository;

import br.com.squad4.blue_bank.model.Telefone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	List<Telefone> findByClienteId(Long idCliente);
}
