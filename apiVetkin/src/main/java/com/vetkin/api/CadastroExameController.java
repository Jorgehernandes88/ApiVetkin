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

import com.vetkin.CadastroExame.CadastroExame;
import com.vetkin.CadastroExame.CadastroExameService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/CadastroExames")
public class CadastroExameController {
	
	@Autowired
	private CadastroExameService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<CadastroExame>> get() {
		return new ResponseEntity<>(service.getCadastroExame(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<CadastroExame> get( @PathVariable("id") Long id) {
		
		Optional<CadastroExame> exame = service.getCadastroExamePorId(id);
		
		if(exame.isPresent())
		{
			return ResponseEntity.ok(exame.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody CadastroExame CadastroExame) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (exameInvalido(CadastroExame))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			CadastroExame cadastroExame = service.save(CadastroExame);

				map.put("idCadastroExame",cadastroExame.getRecID_CadastroExame().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_EXAME);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean exameInvalido(CadastroExame CadastroExame) {
        return CadastroExame.getNome() == "" | CadastroExame.getValorVenda().toString() == "" | CadastroExame.getValorCusto().toString() == ""
        		| CadastroExame.getNome() == null | CadastroExame.getValorVenda() == null | CadastroExame.getValorCusto() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody CadastroExame CadastroExame) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    CadastroExame exame = service.update(CadastroExame, id);
			
			map.put("idCadastroExame", exame.getRecID_CadastroExame().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_EXAME);
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
		
			
		String CadastroExame = service.delete(id);
		
		if(CadastroExame == null)
		{
			map.put(Response.ERRO,Response.ERRO_EXAME_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_EXAME);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
