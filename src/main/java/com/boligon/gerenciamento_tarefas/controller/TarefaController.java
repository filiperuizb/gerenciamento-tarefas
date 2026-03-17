package com.boligon.gerenciamento_tarefas.controller;

import com.boligon.gerenciamento_tarefas.entity.TarefaEntity;
import com.boligon.gerenciamento_tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService projetoService;

    @PostMapping
    public ResponseEntity<TarefaEntity> save(@RequestBody TarefaEntity novoTarefa)  {
        TarefaEntity projeto = projetoService.save(novoTarefa);
        return ResponseEntity.status(201).body(projeto);
    }

    @GetMapping
    public ResponseEntity<List<TarefaEntity>> findAll() {
        List<TarefaEntity> projetoList = projetoService.findAll();
        return projetoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(projetoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity> findById(@PathVariable Long id) {
        Optional<TarefaEntity> projeto = projetoService.findById(id);
        return projeto.isPresent()
                ? ResponseEntity.ok().body(projeto.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        projetoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}