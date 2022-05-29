package com.vetkin.api;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vetkin.ResponseMensager.Response;
import com.vetkin.usuario.Usuario;
import com.vetkin.usuario.UsuarioService;

@RestController
@RequestMapping("/api/v1/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Iterable<Usuario>> get() {
		return new ResponseEntity<>(service.getUsuario(), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> get(@PathVariable("id") Long id) {

		Optional<Usuario> cliente = service.getUsuarioPorId(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@GetMapping("/login/{login}")
	public ResponseEntity<Optional<Usuario>> get(@PathVariable("login") String login) {

		Optional<Usuario> user = service.getUsuarioByLogin(login);

		if (user.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@CrossOrigin
	@GetMapping("/Autorizacao/{login}/{senha}")
	public ResponseEntity<HashMap<String, String>> get(@PathVariable("login") String login,
			@PathVariable("senha") String senha) {

		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;

		Optional<Usuario> user = service.getUsuarioByLogin(login);

		if (user.isEmpty()) {
			map.put(Response.ERRO, Response.ERRO_USUARIO_NAO_ENCONTRADO);
			statusResponse = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);

			return statusResponse;
		} else {

			if (service.autorizacao(login, senha)) {
				map.put(Response.STATUS, Response.SUCESSO_AUTORIZADO);
				statusResponse = new ResponseEntity<>(map, HttpStatus.OK);
				return statusResponse;

			} else {
				map.put(Response.ERRO, Response.ERRO_AUTORIZADO);
				statusResponse = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);

				return statusResponse;
			}
		}
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<HashMap<String, String>> post(@RequestBody Usuario Usuario) {

		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;

		if (usuarioInvalido(Usuario)) {
			map.put(Response.ERRO, Response.ERRO_INCLUIR_CAMPOS_OBRIGATORIOS);
			statusResponse = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);

		} else {
			Usuario usuario = service.save(Usuario);

			map.put("idUsuario", usuario.getRecID_Usuario().toString());
			map.put(Response.STATUS, Response.SUCESSO_INCLUSAO_USUARIO);
			statusResponse = new ResponseEntity<>(map, HttpStatus.OK);
		}

		return statusResponse;
	}

	private boolean usuarioInvalido(Usuario Usuario) {
		return Usuario.getLogin() == "" | Usuario.getPerfil() == "" | Usuario.getSenha() == ""
				| Usuario.getLogin() == null | Usuario.getPerfil() == null | Usuario.getSenha() == null;
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<HashMap<String, String>> put(@PathVariable("id") Long id, @RequestBody Usuario Usuario) {

		HashMap<String, String> map = new HashMap<>();
		ResponseEntity<HashMap<String, String>> statusResponse;

		try {

			Usuario cli = service.update(Usuario, id);

			map.put("idUsuario", cli.getRecID_Usuario().toString());
			map.put(Response.STATUS, Response.SUCESSO_ATUALIZADO_USUARIO);
			statusResponse = new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {

			map.put(Response.ERRO, Response.ERRO_USUARIO_NAO_ENCONTRADO);
			statusResponse = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}

		return statusResponse;
	}

}
