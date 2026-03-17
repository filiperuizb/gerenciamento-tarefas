package com.boligon.gerenciamento_tarefas.service;

import com.boligon.gerenciamento_tarefas.entity.TarefaEntity;
import com.boligon.gerenciamento_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public TarefaEntity save(TarefaEntity novoTarefa) {
        return tarefaRepository.save(novoTarefa);
    }

    public List<TarefaEntity> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaEntity> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

}
