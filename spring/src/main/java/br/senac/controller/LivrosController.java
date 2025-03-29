package br.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.senac.model.Livros;
import br.senac.service.LivrosService;

@RestController
public class LivrosController {
	
	@Autowired
	LivrosService livrosService;
	
	@GetMapping("/livros")
	private List<Livros> getAllLivros(){
		return livrosService.getAllLivros();
	}
	
	@GetMapping("/livros/{id}")
	private Livros getLivrosById(@PathVariable("id") int id) {
		return livrosService.getLivrosById(id);
	}
	
	@PostMapping("/livros")
	private int addLivros(@RequestBody Livros livros) {
		livrosService.addLivros(livros);
		return livros.getId();
	}
	
	@PutMapping("/livros/{id}")
	private ResponseEntity<String> updateLivros(@PathVariable("id") int id,@RequestBody Livros livros){
		livrosService.updateLivros(livros, id);
		return ResponseEntity.ok("Atualizado com sucesso");
	}
	
	@DeleteMapping("/livros/{id}")
	private ResponseEntity<String> deleteLivros(@PathVariable("id") int id){
		livrosService.deleteLivros(id);
		return ResponseEntity.ok("Deletado com sucesso");
	}

}






