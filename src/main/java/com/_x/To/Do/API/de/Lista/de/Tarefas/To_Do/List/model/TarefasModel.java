package com._x.To.Do.API.de.Lista.de.Tarefas.To_Do.List.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "")
    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Column(nullable = false)
    private boolean concluida = false;

    @Column(name = "")
    private LocalDateTime dataCriacao;

    @PrePersist
        public void prePersist() {
            this.dataCriacao = LocalDateTime.now();
        }
    }

