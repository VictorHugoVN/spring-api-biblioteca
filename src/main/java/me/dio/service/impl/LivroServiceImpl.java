package me.dio.service.impl;

import me.dio.domain.model.Livro;
import me.dio.domain.repository.LivroRepository;
import me.dio.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Livro create(Livro livroToCreate) {
        if(livroRepository.livroExists(livroToCreate.getTitulo())){
            throw new IllegalArgumentException("This book already exists.");
        }
        return livroRepository.save(livroToCreate);
    }

    @Override
    public List<Livro> findAll() {
        List<Livro> listLivros = livroRepository.findAll();
        if(listLivros.isEmpty()){
            throw new IllegalArgumentException("No books added yet.");
        }
        return listLivros;
    }

    @Override
    public Livro findById(Long id) {
        return livroRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
