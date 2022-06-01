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
import com.vetkin.Consulta.ConsultaService;
import com.vetkin.Consulta.Consulta;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/Consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Consulta>> get() {
		return new ResponseEntity<>(service.getConsulta(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> get( @PathVariable("id") Long id) {
		
		Optional<Consulta> consulta = service.getConsultaId(id);
		
		if(consulta.isPresent())
		{
			return ResponseEntity.ok(consulta.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Consulta Consulta) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		Consulta consulta = service.save(Consulta);

		map.put("idConsulta",consulta.getRecID_Consulta().toString());
		map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_CONSULTA);
		statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);

		return statusResponse;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Consulta Consulta) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Consulta consulta = service.update(Consulta, id);
			
			map.put("idConsulta", consulta.getRecID_Consulta().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_CONSULTA);
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
		
			
		String consulta = service.delete(id);
		
		if(consulta == null)
		{
			map.put(Response.ERRO,Response.ERRO_CONSULTA_NAO_ENCONTRADA);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_CONSULTA);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
