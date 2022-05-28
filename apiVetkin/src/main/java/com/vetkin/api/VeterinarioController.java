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
import com.vetkin.Veterinario.Veterinario;
import com.vetkin.Veterinario.VeterinarioService;

@RestController
@RequestMapping("/api/v1/Veterinario")
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Veterinario>> get() {
		return new ResponseEntity<>(service.getVeterinario(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Veterinario> get( @PathVariable("id") Long id) {
		
		Optional<Veterinario> veterinario = service.getVeterinarioPorId(id);
		
		if(veterinario.isPresent())
		{
			return ResponseEntity.ok(veterinario.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Veterinario Veterinario) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (veterinarioInvalido(Veterinario))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else{
			
			Veterinario veterinario = service.save(Veterinario);
			
				map.put("idVeterinario",veterinario.getRecID_Veterinario().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_VETERINARIO);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
			
		}

		return statusResponse;
	}
	
    private boolean veterinarioInvalido(Veterinario Veterinario) {
        return Veterinario.getNomeCompleto() == ""  | Veterinario.getEspecialidade() == "" | Veterinario.getTelefone() == ""
        		| Veterinario.getNomeCompleto() == null | Veterinario.getEspecialidade() == null | Veterinario.getTelefone() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Veterinario Veterinario) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Veterinario cli = service.update(Veterinario, id);
			
			map.put("idVeterinario", cli.getRecID_Veterinario().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_VETERINARIO);
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
		
			
		String Veterinario = service.delete(id);
		
		if(Veterinario == null)
		{
			map.put(Response.ERRO,Response.ERRO_VETERINARIO_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_VETERINARIO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
