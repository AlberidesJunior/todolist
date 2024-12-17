
package com.senac.todolist.model;

/**
 *
 * @author Alberides Junior
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoTarefa {

    @Autowired
    private RepositorioTarefa repositorioTarefa;

    // Método para listar todas as tarefas
    public List<Tarefa> listarTarefas() {
        return repositorioTarefa.findAll();
    }

    // Método para salvar nova tarefa
    public void salvarTarefa(Tarefa tarefa) {
        repositorioTarefa.save(tarefa);
    }

    // Método para concluir tarefa
    public void concluirTarefa(Long id) {
        Tarefa tarefa = repositorioTarefa.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setConcluida(true);
        repositorioTarefa.save(tarefa);
    }

    // Método para deletar tarefa
    public void deletarTarefa(Long id) {
        repositorioTarefa.deleteById(id);
    }
}