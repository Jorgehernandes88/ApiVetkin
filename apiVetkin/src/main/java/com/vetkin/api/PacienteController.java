package com.vetkin.api;

import java.util.HashMap;
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
import com.vetkin.paciente.Paciente;
import com.vetkin.paciente.PacienteService;

@RestController
@RequestMapping("/api/v1/Paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Paciente>> get() {
		return new ResponseEntity<>(service.getPaciente(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> get( @PathVariable("id") Long id) {
		
		Optional<Paciente> paciente = service.getPacientePorId(id);
		
		if(paciente.isPresent())
		{
			return ResponseEntity.ok(paciente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Paciente paciente) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (pacienteInvalido(paciente))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			Paciente pacientes = service.save(paciente);
			
			map.put("idPaciente",pacientes.getRecID_Paciente().toString());
			map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_PACIENTE);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
			
		}

		return statusResponse;
	}
	
    private boolean pacienteInvalido(Paciente paciente) {
        return paciente.getNome() == "" | paciente.getRaca() == "" | paciente.getRaca() == ""
        		| paciente.getNome() == null | paciente.getRaca() == null | paciente.getRaca() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
			Paciente pacientes = service.update(paciente, id);
			
			map.put("idPaciente", pacientes.getRecID_Paciente().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_PACIENTE);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
			
		} catch (Exception e) {

			map.put(Response.ERRO,Response.ERRO_ATUALIZAR_REGISTRO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}

		return statusResponse;
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> delete(@PathVariable("id") Long id) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
			
		String paciente = service.delete(id);
		
		if(paciente == null)
		{
			map.put(Response.ERRO,Response.ERRO_PACIENTE_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_PACIENTE);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
}
