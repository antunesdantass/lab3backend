package com.todo.app.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by antunesdantas on 04/02/17.
 */

@Entity
@Table(name = "lista_de_tarefa")
public class ListaDeTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Tarefa> tarefas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
