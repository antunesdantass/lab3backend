package com.todo.app.pojo;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;
import org.hibernate.annotations.Cascade;

/**
 * Created by antunesdantas on 04/02/17.
 */

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private boolean feita;
    @Column
    private Prioridade prioridade;
    @Column
    private String categoria;
    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
    private Set<SubTarefa> subTarefas;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private ListaDeTarefa listaDeTarefa;

    public Set<SubTarefa> getSubTarefas() {
        return subTarefas;
    }

    public void setSubTarefas(Set<SubTarefa> subTarefas) {
        this.subTarefas = subTarefas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
