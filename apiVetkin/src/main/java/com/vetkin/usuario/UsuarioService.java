package com.vetkin.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.vetkin.Utility.PassMD5;
import com.vetkin.cliente.TutorCliente;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;

	public Iterable<Usuario> getUsuario() {
		return rep.findAll();
	}

	public Optional<Usuario> getUsuarioPorId(Long id) {
		return rep.findById(id);
	}

	public Optional<Usuario> getUsuarioByLogin(String login) {
		return rep.findByLogin(login);
	}

	public Usuario save(Usuario Usuario) {
		return rep.save(Usuario);
	}

	public Usuario update(Usuario Usuario, Long id) {

		Assert.notNull(id, "Não foi possivel atualizar o registro");

		Optional<Usuario> optional = getUsuarioPorId(id);
		if (optional.isPresent()) {
			Usuario bd = optional.get();
			// Copiar as propriedades
			bd.setPerfil(Usuario.getPerfil());
			bd.setSenha(Usuario.getSenha());
			bd.setStatus(Usuario.getStatus());

			rep.save(bd);

			return bd;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}

	public boolean autorizacao(String login, String senha) {

		Optional<Usuario> optional = getUsuarioByLogin(login);
		Usuario bd = optional.get();
		
		System.out.println("BANCO: " + PassMD5.passMD5(bd.getSenha().toString()));
		System.out.println("PASSADA: " + senha);
		
		return PassMD5.passMD5(bd.getSenha().toString()).equals(senha);
	}

}
