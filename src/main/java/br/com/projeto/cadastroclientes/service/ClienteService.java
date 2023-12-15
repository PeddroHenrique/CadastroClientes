/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroclientes.service;

import br.com.projeto.cadastroclientes.model.Cliente;
import br.com.projeto.cadastroclientes.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public Cliente alterarCliente(Long id) {
        return clienteRepository.findById(id).get();
    }
}
