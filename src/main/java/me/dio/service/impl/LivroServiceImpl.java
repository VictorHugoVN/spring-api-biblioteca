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
        /*if(!livroRepository.findById(livroToCreate.getId())){
            throw new IllegalArgumentException("This book already exists.");
        }*/
        return livroRepository.save(livroToCreate);
    }

    @Override
    public List<Livro> findAll() {
        List<Livro> listLivros = livroRepository.findAll();
        if(!listLivros.isEmpty()){
            return listLivros;
            //throw new RuntimeException("No books added yet.");
        }
        return null;
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
