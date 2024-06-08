package me.dio.service;

import me.dio.domain.model.Livro;

import java.util.List;

public interface LivroService {

    Livro create(Livro livroToCreate);
    List<Livro> findAll();
    Livro findById(Long id);
    void delete(Long id);

    //Considerar métodos para atualizar livros já existentes.



}
