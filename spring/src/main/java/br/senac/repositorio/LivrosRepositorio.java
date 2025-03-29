package br.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senac.model.Livros;
import java.util.List;

@Repository
public interface LivrosRepositorio extends JpaRepository<Livros, Integer> {
    List<Livros> findByAutorId(int autorId);
}
