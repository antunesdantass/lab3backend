package com.todo.app.controllers;

import com.todo.app.pojo.ListaDeTarefa;
import com.todo.app.pojo.Prioridade;
import com.todo.app.pojo.SubTarefa;
import com.todo.app.pojo.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todo.app.services.ListaDeTarefaService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by antunesdantas on 04/02/17.
 */

@RestController
@RequestMapping("/lista")
public class ListaDeTarefasController {

    private final ListaDeTarefaService service;

    @Autowired
    public ListaDeTarefasController(ListaDeTarefaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<ListaDeTarefa> getAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    ListaDeTarefa create(ListaDeTarefa novaLista) {
        return service.create(novaLista);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ListaDeTarefa update(@PathVariable("id") Long id, @RequestBody @Valid ListaDeTarefa listaAtualizada) {
        if (listaAtualizada.getId() == id) {
            return service.update(listaAtualizada);
        }
        else return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    void deleteAll() {
        service.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    ListaDeTarefa criarListas() {
        SubTarefa sub = new SubTarefa();
        sub.setId(1L);
        sub.setDescricao("carai de asa");
        sub.setFeita(false);
        Tarefa tarefa = new Tarefa();
        tarefa.setFeita(false);
        tarefa.setDescricao("testando");
        tarefa.setId(1L);
        tarefa.setCategoria("nao sei");
        tarefa.setPrioridade(Prioridade.MEDIA);
        tarefa.setTitulo("23 testando");
        Set<SubTarefa> subTarefas = new HashSet<>();
        subTarefas.add(sub);
        tarefa.setSubTarefas(subTarefas);
        ListaDeTarefa lista = new ListaDeTarefa();
        lista.setId(1L);
        lista.setNome("antunes");
        Set<Tarefa> tarefas = new HashSet<>();
        tarefas.add(tarefa);
        lista.setTarefas(tarefas);
        return lista;
    }

}
