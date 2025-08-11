package com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.repository;

import com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {

    List<TarefasModel> findByConcluida(boolean concluida);

}
