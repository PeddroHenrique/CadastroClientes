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
public class ClienteController {

    @Autowired
    private AtendimentoService atendimentoService;    
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar-clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarCliente());
        return "cliente/listarClientes";
    }

    @GetMapping("/adicionar-cliente")
    public String adicionarCliente(Cliente cliente) {
        return "cliente/adicionarCliente";
    }

    @PostMapping("/adicionar-cliente")
    public String cadastrarCliente(@Valid Cliente cliente, BindingResult resultado, Model model) {

        if (resultado.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "cliente/adicionarCliente";
        }

        clienteService.salvarCliente(cliente);
        return "redirect:/cliente/listar-clientes";
    }

    @PostMapping("/deletar-cliente/{id}")
    public String deletarCliente(@PathVariable("id") Long id) {
        for (Atendimento atendimento : atendimentoService.listarAtendimento(id)) {
            atendimentoService.deletarAtendimento(atendimento.getId());
        }    
        clienteService.deletarCliente(id);
        return "redirect:/cliente/listar-clientes";
    }

    @GetMapping("/alterar-cliente/{id}")
    public String alterarCliente(@PathVariable("id") Long id, Model model) {

        model.addAttribute("cliente", clienteService.alterarCliente(id));
        return "cliente/alterarCliente";
    }
    
    @PostMapping("/alterar-cliente")
    public String salvarAlterarCliente(@Valid Cliente cliente, BindingResult resultado, Model model) {
        
        if (resultado.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "cliente/alterarCliente";
        }
        
        clienteService.salvarCliente(cliente);
        return "redirect:/cliente/listar-clientes";
    }
}
