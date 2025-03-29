package br.senac.service;


import br.senac.model.Livros;
import br.senac.repositorio.LivrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {
    
    @Autowired
    LivrosRepositorio livrosRepositorio;
    
    public List<Livros> getAllLivros() {
        return livrosRepositorio.findAll();
    }
    
    public Livros getLivrosById(int id) {
        return livrosRepositorio.findById(id).orElse(null);
    }
    
    public void addLivros(Livros livros) {
        livrosRepositorio.save(livros);
    }
    
    public void updateLivros(Livros livros, int id) {
        if (livrosRepositorio.existsById(id)) {
            livros.setId(id);
            livrosRepositorio.save(livros);
        }
    }
    
    public void deleteLivros(int id) {
        livrosRepositorio.deleteById(id);
    }
    
    public List<Livros> getLivrosByAutorId(int autorId) {
        return livrosRepositorio.findByAutorId(autorId);
    }
}