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

import com.vetkin.ItensExames.ItensExames;
import com.vetkin.ItensExames.ItensExamesService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/ItensExames")
public class ItensExamesController {
	
	@Autowired
	private ItensExamesService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<ItensExames>> get() {
		return new ResponseEntity<>(service.getConsulta_Exames(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<ItensExames> get( @PathVariable("id") Long id) {
		
		Optional<ItensExames> exame = service.getConsulta_ExamesById(id);
		
		if(exame.isPresent())
		{
			return ResponseEntity.ok(exame.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody ItensExames Consulta_Exames) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		ItensExames itensExames = service.save(Consulta_Exames);

		map.put("idConsulta_Exames",itensExames.getRecID_ItensExames().toString());
		map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_CONSULTA_EXAME);
		statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);

		return statusResponse;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody ItensExames Consulta_Exames) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    ItensExames exame = service.update(Consulta_Exames, id);
			
			map.put("idConsulta_Exames", exame.getRecID_ItensExames().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_CONSULTA_EXAME);
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
		
			
		String Consulta_Exames = service.delete(id);
		
		if(Consulta_Exames == null)
		{
			map.put(Response.ERRO,Response.ERRO_CONSULTA_EXAME_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_CONSULTA_EXAME);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
