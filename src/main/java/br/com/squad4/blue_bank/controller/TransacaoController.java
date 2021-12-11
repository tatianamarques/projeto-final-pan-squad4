package br.com.squad4.blue_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.squad4.blue_bank.form.TranferenciaoForm;
import br.com.squad4.blue_bank.form.TransacaoForm;
import br.com.squad4.blue_bank.services.TransacaoService;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;

	@PostMapping("/depositar")
	public ResponseEntity<String> depositar(@RequestBody TransacaoForm transacaoForm) {
		transacaoService.depositar(transacaoForm.getContaId(), transacaoForm.getValor());
		return ResponseEntity.ok("Depósito efetuado com sucesso");

	}

	@PostMapping("/sacar")
	public ResponseEntity<String> sacar(@RequestBody TransacaoForm transacaoForm) {
		if (transacaoService.sacar(transacaoForm.getContaId(), transacaoForm.getValor())) {
			return ResponseEntity.ok("Saque efetuado com sucesso");
		}
		return ResponseEntity.badRequest().body("Não foi possível efetuar o saque");
	}

	@PostMapping("/transferencia")
	public ResponseEntity<String> transferencia(@RequestBody TranferenciaoForm transferenciaForm) {
		if (transacaoService.transferencia(transferenciaForm.getIdContaDeposito(), transferenciaForm.getIdContaSaque(),
				transferenciaForm.getValor())) {
			return ResponseEntity.ok("Transferência efetuada com sucesso");
		}
		return ResponseEntity.badRequest().body("Não foi possível efetuar a transferência");
	}

}
