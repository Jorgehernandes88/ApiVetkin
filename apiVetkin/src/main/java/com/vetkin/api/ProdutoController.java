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
import com.vetkin.CadastroProduto.Produto;
import com.vetkin.CadastroProduto.ProdutoService;
import com.vetkin.ResponseMensager.Response;


@RestController
@RequestMapping("/api/v1/Produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Produto>> get() {
		return new ResponseEntity<>(service.getCadastroProduto(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Produto> get( @PathVariable("id") Long id) {
		
		Optional<Produto> exame = service.getCadastroProdutoPorId(id);
		
		if(exame.isPresent())
		{
			return ResponseEntity.ok(exame.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Produto CadastroProduto) {
		
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		if (exameInvalido(CadastroProduto))
		{
			map.put(Response.ERRO,Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else
		{
			Produto produto = service.save(CadastroProduto);

				map.put("idCadastroProduto",produto.getRecID_Produto().toString());
				map.put(Response.STATUS,Response.SUCESSO_INCLUSAO_PRODUTO);
				statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);
		}

		return statusResponse;
	}
	
    private boolean exameInvalido(Produto CadastroProduto) {
        return CadastroProduto.getNome() == "" | CadastroProduto.getValorVenda().toString() == "" | CadastroProduto.getValorCusto().toString() == ""
        		| CadastroProduto.getNome() == null | CadastroProduto.getValorVenda() == null | CadastroProduto.getValorCusto() == null;
    }

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Produto CadastroProduto) {
	
		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;
		
		try {
			
		    Produto produto = service.update(CadastroProduto, id);
			
			map.put("idCadastroProduto", produto.getRecID_Produto().toString());
			map.put(Response.STATUS,Response.SUCESSO_ATUALIZADO_PRODUTO);
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
		
			
		String CadastroProduto = service.delete(id);
		
		if(CadastroProduto == null)
		{
			map.put(Response.ERRO,Response.ERRO_PRODUTO_NAO_ENCONTRADO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}else {
			map.put(Response.STATUS,Response.SUCESSO_EXCLUSAO_PRODUTO);
			statusResponse =  new ResponseEntity<>(map,HttpStatus.OK);	
		}
		
		return statusResponse;
	}
	
	
}
