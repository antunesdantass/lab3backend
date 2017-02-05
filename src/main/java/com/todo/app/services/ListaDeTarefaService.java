package com.todo.app.services;

import com.todo.app.pojo.ListaDeTarefa;
import com.todo.app.repository.ListaDeTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antunesdantas on 04/02/17.
 */

@Service
public class ListaDeTarefaService {

    private final ListaDeTarefaRepository repository;

    @Autowired
    public ListaDeTarefaService(ListaDeTarefaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ListaDeTarefa create(ListaDeTarefa lista) {
        return repository.save(lista);
    }

    @Transactional
    public List<ListaDeTarefa> findAll() {
        Iterable<ListaDeTarefa> list =  repository.findAll();
        List<ListaDeTarefa> listaDeTarefas = new ArrayList<ListaDeTarefa>();
        for (ListaDeTarefa listaDeTarefa : list) {
            listaDeTarefas.add(listaDeTarefa);
        }

        return listaDeTarefas;
    }

    @Transactional
    public ListaDeTarefa update(ListaDeTarefa listaAtualizada) {
        return repository.save(listaAtualizada);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

}
