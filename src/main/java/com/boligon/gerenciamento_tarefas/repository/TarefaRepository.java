package com.boligon.gerenciamento_tarefas.repository;

import com.boligon.gerenciamento_tarefas.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
