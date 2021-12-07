package com.vetkin.api;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vetkin.ResponseMensager.Response;
import com.vetkin.cliente.TutorCliente;
import com.vetkin.cliente.TutorClienteService;

@RestController
@RequestMapping("/api/v1/TutorClientes")
public class TutorClienteController {
	
	@Autowired
	private TutorClienteService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<TutorCliente>> get() {
		return new ResponseEntity<>(service.getTutorClientes(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<TutorCliente> get( @PathVariable("id") Long id) {
		
		Optional<TutorCliente> cliente = service.getTutorClienteById(id);
		
		if(cliente.isPresent())
		{
			return ResponseEntity.ok(cliente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@GetMapping("/cpf/{cpf}")
	public  ResponseEntity<List<TutorCliente>> get( @PathVariable("cpf") String cpf) {
		
		List<TutorCliente> cliente = service.getTutorClientesByCpf(cpf);
		
		if(cliente.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(cliente);
		}
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody TutorCliente TutorCliente) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (tutorInvalido(TutorCliente))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}else {
			
			TutorCliente tutorCliente = service.save(TutorCliente);
			
			map.put("idTutorCliente",tutorCliente.getRecID_TutorCliente().toString());
			map.put(Response.STATUS,Response.SUCESSO_INCLUSAO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean tutorInvalido(TutorCliente TutorCliente) {
        return TutorCliente.getNomeCompleto() == "" | TutorCliente.getCpf() == "" | TutorCliente.getTelefone() == ""
        		| TutorCliente.getNomeCompleto() == null | TutorCliente.getCpf() == null | TutorCliente.getTelefone() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody TutorCliente TutorCliente) {
	
		TutorCliente cli = service.update(TutorCliente, id);
				
		return "[{idCliente: " + cli.getRecID_TutorCliente() + "}]";
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
	
		service.delete(id);
				
		return "Tutor deletado";
	}
	
	
}
