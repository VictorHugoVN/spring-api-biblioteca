package me.dio.controller;

import me.dio.domain.model.Livro;
import me.dio.service.LivroService;
import me.dio.service.impl.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroServiceImpl livroService;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livroToCreate){
        var livroCreated = livroService.create(livroToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(livroCreated);
    }

    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        var livro = livroService.findById(id);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping
    public void delete(Long id){
        livroService.delete(id);
    }



}
