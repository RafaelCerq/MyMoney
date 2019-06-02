package com.example.money.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.money.api.event.RecursoCriadoEvent;
import com.example.money.api.model.Categoria;
import com.example.money.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	//Autowired para utilizar os recursos do JPA direto na interf
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@CrossOrigin(maxAge = 10, origins = { "http://localhost:8000" })
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
/*	retornar 204 - no Content quando não encontra informações no servidor
	public ResponseEntity<?> listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		//Se a lista n]ao estiver vazia responde 200, senão retorna 204
		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
	}
*/
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)//como já tem o response no return, nao precisa desta notação
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(categoriaSalva.getCodigo()).toUri();
//		response.setHeader("Location", uri.toASCIIString());
//		
//		return ResponseEntity.created(uri).body(categoriaSalva);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);	
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPeloCodigo(@PathVariable Long codigo) {
		return categoriaRepository.findById(codigo).get();
	}
}
