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

import com.vetkin.ItensProdutos.ItensProdutos;
import com.vetkin.ItensProdutos.ItensProdutosService;
import com.vetkin.ItensProdutos.ItensProdutosService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/ItensProdutos")
public class ItensProdutosController {
	
	@Autowired
	private ItensProdutosService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<ItensProdutos>> get() {
		return new ResponseEntity<>(service.getItensProdutos(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<ItensProdutos> get( @PathVariable("id") Long id) {
		
		Optional<ItensProdutos> produtos = service.getItensProdutosId(id);
		
		if(produtos.isPresent())
		{
			return ResponseEntity.ok(produtos.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody ItensProdutos ItensProdutos) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		ItensProdutos itensProdutos = service.save(ItensProdutos);

		map.put("idItensProdutos",itensProdutos.getRecID_ItensProdutos().toString());
		map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_ITENS_PRODUTOS);
		statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);

		return statusResponse;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody ItensProdutos ItensProdutos) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    ItensProdutos produto = service.update(ItensProdutos, id);
			
			map.put("idItensProdutos", produto.getRecID_ItensProdutos().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_ITENS_PRODUTOS);
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
			map.put(Response.ERRO,Response.ERRO_ITENS_PRODUTOS_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_ITENS_PRODUTOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
