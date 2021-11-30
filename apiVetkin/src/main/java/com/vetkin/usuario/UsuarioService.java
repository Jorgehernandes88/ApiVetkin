package com.vetkin.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository rep;
		
	public Iterable<Usuario> getUsuario(){
		return rep.findAll();
	}
	
	public Optional<Usuario> getUsuarioPorId(Long id){
		return rep.findById(id);
	}
	
	public Usuario save(Usuario Usuario) {
		return rep.save(Usuario);
	}
	
	public Usuario update(Usuario Usuario, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Usuario> optional = getUsuarioPorId(id);
		if(optional.isPresent())
		{
			Usuario bd = optional.get();
			// Copiar as propriedades
			bd.setPerfil(Usuario.getPerfil());
			bd.setSenha(Usuario.getSenha());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<Usuario> cliente = getUsuarioPorId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
