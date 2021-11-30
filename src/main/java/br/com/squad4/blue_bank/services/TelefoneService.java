package br.com.squad4.blue_bank.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad4.blue_bank.form.TelefoneForm;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.TelefoneRepository;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    

    @Transactional
    public Telefone salvar(TelefoneForm telefoneForm,Optional<Cliente> cliente){
        Optional<Telefone> telefone = telefoneForm.toModel(cliente);
        telefoneRepository.save(telefone.get());
      return telefone.get();

    }

    @Transactional
	public boolean deletar(Long id) {
		Optional<Telefone> telefone = telefoneRepository.findById(id);
		if(telefone.isPresent()) {
			telefoneRepository.deleteById(id);
			return true;
		}
		return false;
		
	}



}
