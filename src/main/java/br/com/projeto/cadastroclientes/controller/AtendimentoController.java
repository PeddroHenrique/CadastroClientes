/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroclientes.controller;

import br.com.projeto.cadastroclientes.model.Atendimento;
import br.com.projeto.cadastroclientes.model.Cliente;
import br.com.projeto.cadastroclientes.service.AtendimentoService;
import br.com.projeto.cadastroclientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pedro
 */
@Controller
@RequestMapping("cliente")
public class AtendimentoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping("/listar-atendimentos/{id}")
    public String listarAtendimentos(@PathVariable("id") Long id, Model model) {
        model.addAttribute("atendimentos", atendimentoService.listarAtendimento(id));
        model.addAttribute("cliente", clienteService.alterarCliente(id));
        return "atendimento/listarAtendimento";
    }

    @GetMapping("/adicionar-atendimento/{id}")
    public String adicionarAtendimento(@PathVariable("id") Long id, Atendimento atendimento, Cliente cliente, Model model) {
        cliente = clienteService.alterarCliente(id);
        atendimento.setCliente(cliente);
        model.addAttribute("cliente", cliente);
        model.addAttribute("atendimento", atendimento);
        return "atendimento/adicionarAtendimento";
    }

    @PostMapping("/salvar-atendimento/{id}")
    public String salvarAtendimento(@PathVariable("id") Long id, @Valid Atendimento atendimento, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("cliente", clienteService.alterarCliente(id));
            model.addAttribute("atendimento", atendimento);
            return "atendimento/adicionarAtendimento";
        }
        
        atendimento.setId(null);
        
        atendimentoService.salvarAtendimento(atendimento);
        return "redirect:/cliente/listar-atendimentos/" + atendimento.getCliente().getId();
    }

    @PostMapping("/deletar-atendimento/{id}")
    public String deletarAtendimento(@PathVariable("id") Long id) {
        Long clienteId = atendimentoService.alterarAtendimento(id).getCliente().getId();
        atendimentoService.deletarAtendimento(id);
        return "redirect:/cliente/listar-atendimentos/" + clienteId;
    }

    @GetMapping("/alterar-atendimento/{id}")
    public String alterarAtendimento(@PathVariable("id") Long id, Model model) {
        model.addAttribute("atendimento", atendimentoService.alterarAtendimento(id));
        model.addAttribute("id", id);
        return "atendimento/alterarAtendimento";
    }

    @PostMapping("/alterar-atendimento")
    public String salvarAlterarAtendimento(Atendimento atendimento) {
        atendimentoService.salvarAtendimento(atendimento);
        return "redirect:/cliente/listar-atendimento";
    }
}
