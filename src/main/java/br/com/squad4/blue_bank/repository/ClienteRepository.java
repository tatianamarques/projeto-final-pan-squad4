package br.com.squad4.blue_bank.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.squad4.blue_bank.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Override
    Optional<Cliente> findById(Long id);
    
    @Query(nativeQuery = true,name = "cpfExiste",value = "SELECT cpf FROM cliente where cpf = :cpf")
	String cpfExiste(String cpf);

	@Query(nativeQuery = true,name = "emailExiste",value = "SELECT email FROM cliente where email = :email")
	String emailExiste(String email);

	Optional<Cliente> findByCpf(String cpf);

	Page<Cliente> findByNomeContainingIgnoreCase(String nome,Pageable paginacao);
    
}
