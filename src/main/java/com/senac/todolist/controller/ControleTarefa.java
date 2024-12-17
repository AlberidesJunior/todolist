
package com.senac.todolist.controller;

/**
 *
 * @author Alberides Junior
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.senac.todolist.model;

@Controller
public class ControleTarefa {

    @Autowired
    private ServicoTarefa servicoTarefa;

    @GetMapping("/")
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", servicoTarefa.listarTarefas());
        return "index"; // Retorna a página index.html
    }

    @GetMapping("/criar-tarefa")
    public String exibirFormularioDeCriacao() {
        return "criar-tarefa"; // Retorna a página para criar tarefa
    }

    @PostMapping("/salvar-tarefa")
    public String salvarTarefa(@RequestParam String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);
        tarefa.setConcluida(false);
        servicoTarefa.salvarTarefa(tarefa);
        return "redirect:/"; // Redireciona para a página principal
    }

    @GetMapping("/concluir-tarefa")
    public String concluirTarefa(@RequestParam Long id) {
        servicoTarefa.concluirTarefa(id);
        return "redirect:/";
    }

    @GetMapping("/deletar-tarefa")
    public String deletarTarefa(@RequestParam Long id) {
        servicoTarefa.deletarTarefa(id);
        return "redirect:/";
    }
}