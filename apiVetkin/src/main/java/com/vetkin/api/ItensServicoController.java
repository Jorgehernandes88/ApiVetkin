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
import com.vetkin.ItensServico.ItensServico;
import com.vetkin.ItensServico.ItensServicoService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/ItensServico")
public class ItensServicoController {
	
	@Autowired
	private ItensServicoService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<ItensServico>> get() {
		return new ResponseEntity<>(service.getItensServico(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<ItensServico> get( @PathVariable("id") Long id) {
		
		Optional<ItensServico> servico = service.getItensServicoId(id);
		
		if(servico.isPresent())
		{
			return ResponseEntity.ok(servico.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody ItensServico ItensServico) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		ItensServico itensServico = service.save(ItensServico);

		map.put("idItensServico",itensServico.getRecID_ItensServicos().toString());
		map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_ITENS_SERVICOS);
		statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);

		return statusResponse;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody ItensServico ItensServico) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    ItensServico servico = service.update(ItensServico, id);
			
			map.put("idItensServico", servico.getRecID_ItensServicos().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_ITENS_SERVICOS);
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
		
			
		String ItensServico = service.delete(id);
		
		if(ItensServico == null)
		{
			map.put(Response.ERRO,Response.ERRO_ITENS_SERVICO_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_ITENS_SERVICOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
