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

import com.vetkin.CadastroServico.CadastroServico;
import com.vetkin.CadastroServico.CadastroServicoService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/CadastroServicos")
public class CadastroServicoController {
	
	@Autowired
	private CadastroServicoService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<CadastroServico>> get() {
		return new ResponseEntity<>(service.getCadastroServico(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<CadastroServico> get( @PathVariable("id") Long id) {
		
		Optional<CadastroServico> servico = service.getCadastroServicoPorId(id);
		
		if(servico.isPresent())
		{
			return ResponseEntity.ok(servico.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody CadastroServico CadastroServico) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (servicoInvalido(CadastroServico))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			CadastroServico cadastroServico = service.save(CadastroServico);

				map.put("idCadastroServico",cadastroServico.getRecID_CadastroExame().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_SERVICO);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean servicoInvalido(CadastroServico CadastroServico) {
        return CadastroServico.getNome() == "" | CadastroServico.getValorVenda().toString() == "" | CadastroServico.getValorCusto().toString() == ""
        		| CadastroServico.getNome() == null | CadastroServico.getValorVenda() == null | CadastroServico.getValorCusto() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody CadastroServico CadastroServico) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    CadastroServico exame = service.update(CadastroServico, id);
			
			map.put("idCadastroServico", exame.getRecID_CadastroExame().toString());
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
