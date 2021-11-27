package br.com.squad4.blue_bank.repository;

import br.com.squad4.blue_bank.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findByClienteId(Long id);
}
