package me.dio.domain.repository;

import me.dio.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {


}
