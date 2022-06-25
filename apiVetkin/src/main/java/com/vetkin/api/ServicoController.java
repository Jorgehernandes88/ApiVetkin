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

import com.vetkin.CadastroServico.Servico;
import com.vetkin.CadastroServico.ServicoService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/Servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Servico>> get() {
		return new ResponseEntity<>(service.getCadastroServico(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Servico> get( @PathVariable("id") Long id) {
		
		Optional<Servico> servico = service.getCadastroServicoPorId(id);
		
		if(servico.isPresent())
		{
			return ResponseEntity.ok(servico.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Servico CadastroServico) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (servicoInvalido(CadastroServico))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			Servico cadastroServico = service.save(CadastroServico);

				map.put("idCadastroServico",cadastroServico.getRecID_Servico().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_SERVICO);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean servicoInvalido(Servico CadastroServico) {
        return CadastroServico.getNome() == "" | CadastroServico.getValorVenda().toString() == "" | CadastroServico.getValorCusto().toString() == ""
        		| CadastroServico.getNome() == null | CadastroServico.getValorVenda() == null | CadastroServico.getValorCusto() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Servico CadastroServico) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Servico exame = service.update(CadastroServico, id);
			
			map.put("idCadastroServico", exame.getRecID_Servico().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_SERVICO);
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
		
			
		String CadastroServico = service.delete(id);
		
		if(CadastroServico == null)
		{
			map.put(Response.ERRO,Response.ERRO_SERVICO_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_SERVICO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
