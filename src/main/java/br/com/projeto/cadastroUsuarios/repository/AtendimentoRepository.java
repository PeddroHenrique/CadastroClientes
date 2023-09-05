/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.projeto.cadastroUsuarios.repository;

import br.com.projeto.cadastroUsuarios.model.Atendimento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro
 */
@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    
    @Query("SELECT a FROM Atendimento a WHERE a.cliente.id = :clienteId")
    List<Atendimento> findAllByClienteId(@Param("clienteId") Long clienteId);
}
