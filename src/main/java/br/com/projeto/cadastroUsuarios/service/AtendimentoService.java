/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroUsuarios.service;

import br.com.projeto.cadastroUsuarios.model.Atendimento;
import br.com.projeto.cadastroUsuarios.repository.AtendimentoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class AtendimentoService {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    
    public List<Atendimento> listarAtendimento(Long id) {
        return atendimentoRepository.findAllByClienteId(id);
    }
    
    public void salvarAtendimento(Atendimento atendimento) {
        atendimento.setData(new Date());
        atendimentoRepository.save(atendimento);
    }
    
    public void deletarAtendimento(Long id) {
        atendimentoRepository.deleteById(id);
    }
    
    public Atendimento alterarAtendimento(Long id) {
        return atendimentoRepository.findById(id).get();
    }
}
