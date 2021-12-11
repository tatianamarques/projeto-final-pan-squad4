package br.com.squad4.blue_bank;

import br.com.squad4.blue_bank.model.Gerente;
import br.com.squad4.blue_bank.repository.GerenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BlueBankApplication{
	@Autowired
	private GerenteDao gerenteDao;

	@Bean
	Supplier<List<Gerente>> gerentes(){
		return () -> gerenteDao.buildGerentes();
	}

	@Bean
	public Function<String, List<Gerente>> findGerentebyName(){
		return (input) -> gerenteDao.buildGerentes().stream().filter(gerente ->gerente.getNome().equals(input)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(BlueBankApplication.class, args);
	}


}