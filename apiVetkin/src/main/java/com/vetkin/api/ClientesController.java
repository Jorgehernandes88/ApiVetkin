package com.vetkin.api;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetkin.cliente.TutorCliente;
import com.vetkin.cliente.TutorClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {
	
	@Autowired
	private TutorClienteService service;
	
	@GetMapping()
	public ResponseEntity<Iterable<TutorCliente>> get() {
		return new ResponseEntity<>(service.getClientes(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TutorCliente> get( @PathVariable("id") Long id) {
		
		Optional<TutorCliente> cliente = service.getClienteById(id);
		
		if(cliente.isPresent())
		{
			return ResponseEntity.ok(cliente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/cpf/{cpf}")
	public  ResponseEntity<List<TutorCliente>> get( @PathVariable("cpf") String cpf) {
		
		List<TutorCliente> cliente = service.getClientesByCpf(cpf);
		
		if(cliente.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(cliente);
		}
	}
	
	@PostMapping
	public String post(@RequestBody TutorCliente TutorCliente) {
	
		TutorCliente cli = service.save(TutorCliente);
				
		return "[{idCliente: " + cli.getRecID_TutorCliente() + "}]";
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody TutorCliente TutorCliente) {
	
		TutorCliente cli = service.update(TutorCliente, id);
				
		return "[{idCliente: " + cli.getRecID_TutorCliente() + "}]";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
	
		service.delete(id);
				
		return "Tutor deletado";
	}
	
	
}
