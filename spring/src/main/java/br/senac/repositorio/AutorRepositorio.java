package br.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senac.model.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {
}