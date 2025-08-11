package com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.service;


import com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.model.TarefasModel;
import com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository tarefasRepository;

    public TarefasModel criarTarefa(TarefasModel tarefa) {
        return tarefasRepository.save(tarefa);
    }

    public List<TarefasModel> listarTodas() {
        return tarefasRepository.findAll();
    }

    public List<TarefasModel> listarPorStatus(boolean concluida) {
        return tarefasRepository.findByConcluida(concluida);
    }

    public Optional<TarefasModel> BuscarPorId(Long id) {
        return tarefasRepository.findById(id);
    }

    public Optional<TarefasModel> concluirTarefa(Long id) {
        Optional<TarefasModel> tarefaOpt = tarefasRepository.findById(id);
        if (tarefaOpt.isPresent()) {
            TarefasModel tarefasModel = tarefaOpt.get();
            tarefasModel.setConcluida(true);
            tarefasRepository.save(tarefasModel);
        }
        return tarefaOpt;
    }

    public boolean deletartarefa(Long id) {
        if (tarefasRepository.existsById(id)) {
            tarefasRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
