package br.com.squad4.blue_bank.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.squad4.blue_bank.repository.ClienteRepository;

@Component
public class CpfUnicoValidator implements ConstraintValidator<CpfUnico,String>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private String value;
	 
    @Override
    public void initialize(CpfUnico constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		this.value = clienteRepository.cpfExiste(value);
		if(this.value == null) {
			return true;
		}
		return false;
	}

}
