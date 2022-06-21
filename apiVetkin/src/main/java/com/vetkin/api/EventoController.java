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
import com.vetkin.Evento.EventoService;
import com.vetkin.Evento.EventoService;
import com.vetkin.Evento.Evento;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/Evento")
public class EventoController {
	
	@Autowired
	private EventoService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Evento>> get() {
		return new ResponseEntity<>(service.getEvento(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Evento> get( @PathVariable("id") Long id) {
		
		Optional<Evento> Evento = service.getEventoPorId(id);
		
		if(Evento.isPresent())
		{
			return ResponseEntity.ok(Evento.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Evento Evento) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		Evento evento = service.save(Evento);

		map.put("idEvento",evento.getRecID_Evento().toString());
		map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_EVENTO);
		statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);

		return statusResponse;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Evento Evento) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Evento evento = service.update(Evento, id);
			
			map.put("idEvento", evento.getRecID_Evento().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_EVENTO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
			
		} catch (Exception e) {

			map.put(Response.ERRO,Response.ERRO_ATUALIZAR_REGISTRO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}

		return statusResponse;
	}	
}
