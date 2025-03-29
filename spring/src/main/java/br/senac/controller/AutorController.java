package br.senac.controller;

import br.senac.model.Autor;
import br.senac.model.Livros;
import br.senac.service.AutorService;
import br.senac.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    AutorService autorService;
    
    @Autowired
    LivrosService livrosService;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable("id") int id) {
        return autorService.getAutorById(id);
    }

    @PostMapping
    public int addAutor(@RequestBody Autor autor) {
        autorService.addAutor(autor);
        return autor.getId();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAutor(@PathVariable("id") int id, @RequestBody Autor autor) {
        autorService.updateAutor(autor, id);
        return ResponseEntity.ok("Atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable("id") int id) {
        autorService.deleteAutor(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
    
    @GetMapping("/{id}/livros")
    public List<Livros> getLivrosByAutor(@PathVariable("id") int autorId) {
        return livrosService.getLivrosByAutorId(autorId);
    }
}