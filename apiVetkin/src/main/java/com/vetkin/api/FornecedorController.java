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
import com.vetkin.Fornecedor.Fornecedor;
import com.vetkin.Fornecedor.FornecedorService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/Fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Fornecedor>> get() {
		return new ResponseEntity<>(service.getFornecedor(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> get( @PathVariable("id") Long id) {
		
		Optional<Fornecedor> exame = service.getFornecedorPorId(id);
		
		if(exame.isPresent())
		{
			return ResponseEntity.ok(exame.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Fornecedor Fornecedor) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (fornecedorInvalido(Fornecedor))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			Fornecedor fornecedor = service.save(Fornecedor);

				map.put("idFornecedor",fornecedor.getRecID_Fornecedor().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_FORNECEDOR);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean fornecedorInvalido(Fornecedor Fornecedor) {
        return Fornecedor.getNome() == "" | Fornecedor.getContato().toString() == "" 
        		| Fornecedor.getNome() == null | Fornecedor.getContato() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Fornecedor Fornecedor) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Fornecedor exame = service.update(Fornecedor, id);
			
			map.put("idFornecedor", exame.getRecID_Fornecedor().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_FORNECEDOR);
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
		
			
		String Fornecedor = service.delete(id);
		
		if(Fornecedor == null)
		{
			map.put(Response.ERRO,Response.ERRO_FORNECEDOR_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_FORNECEDOR);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
