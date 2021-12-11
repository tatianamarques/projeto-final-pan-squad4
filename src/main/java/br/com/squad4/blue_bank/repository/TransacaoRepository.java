package br.com.squad4.blue_bank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squad4.blue_bank.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao,Long>{

	Page<Transacao> findByContaId(Long contaId,Pageable pageable);

}
