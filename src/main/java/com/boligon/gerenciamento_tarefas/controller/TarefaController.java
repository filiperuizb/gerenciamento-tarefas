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
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaEntity> save(@RequestBody TarefaEntity novoTarefa)  {
        TarefaEntity tarefa = tarefaService.save(novoTarefa);
        return ResponseEntity.status(201).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaEntity>> findAll() {
        List<TarefaEntity> tarefaList = tarefaService.findAll();
        return tarefaList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(tarefaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity> findById(@PathVariable Long id) {
        Optional<TarefaEntity> tarefa = tarefaService.findById(id);
        return tarefa.isPresent()
                ? ResponseEntity.ok().body(tarefa.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        tarefaService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TarefaEntity> atualizar(@PathVariable Long id, @RequestBody TarefaEntity atualizarTarefa) {
        TarefaEntity entity = tarefaService.atualizar(id, atualizarTarefa);

        return ResponseEntity.ok(entity);
    }
}