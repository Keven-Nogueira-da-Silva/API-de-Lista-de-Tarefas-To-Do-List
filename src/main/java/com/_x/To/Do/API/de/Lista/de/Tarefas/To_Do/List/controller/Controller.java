package com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.controller;


import com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.model.TarefasModel;
import com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.service.TarefasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class Controller {

    @Autowired
    private TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasModel> criar(@Valid @RequestBody TarefasModel tarefasModel) {
        return ResponseEntity.ok(tarefasService.criarTarefa(tarefasModel));
    }

    @GetMapping
    public ResponseEntity<List<TarefasModel>> listarTodas() {
        return ResponseEntity.ok(tarefasService.listarTodas());
    }

    @GetMapping("/status/{concluida}")
    public ResponseEntity<List<TarefasModel>> listarPorStatus(@PathVariable boolean concluida) {
        return ResponseEntity.ok(tarefasService.listarPorStatus(concluida));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefasModel> buscarPorId(@PathVariable Long id) {
        return tarefasService.BuscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/concluir")
    public ResponseEntity<TarefasModel> concluir(@PathVariable Long id) {
        return tarefasService.concluirTarefa(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = tarefasService.deletartarefa(id);
        if(deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
