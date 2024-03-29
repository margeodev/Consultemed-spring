package com.consultemed.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultemed.model.Usuario;
import com.consultemed.repository.filter.UsuarioFilter;
import com.consultemed.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
//	########## GET ##########
	@GetMapping
	public List<Usuario> listar(UsuarioFilter filter) {
		return service.pesquisar(filter);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Usuario usuario = service.procurarPorId(id);		
		return ResponseEntity.ok(usuario);
	}

//	########## POST ##########
	@PostMapping
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return service.salvar(usuario);
	}
		
//	########## PUT ##########
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid Usuario usuario, @PathVariable Long id) {
		Usuario usuarioBanco = service.procurarPorId(id);	
		usuario.setId(id);
		usuarioBanco = service.salvar(usuario);
		return ResponseEntity.ok(usuarioBanco);
	}
	
//	########## DELETE ##########
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> excluir(@PathVariable Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
