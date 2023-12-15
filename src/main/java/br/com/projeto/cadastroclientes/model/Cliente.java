/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroclientes.model;

import br.com.projeto.cadastroclientes.validation.constraints.Telefone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O campo NOME é obrigatório.")
    @Size(max = 75, message = "O campo NOME deve conter no máximo 75 caracteres.")
    @Column(name = "nome", columnDefinition = "varchar(75)", nullable = false)
    private String nome;
    
    @Column(name = "idade", columnDefinition = "int", nullable = false)
    private int idade;
    
    @Telefone(message = "É necessário conter um TELEFONE válido.")
    @Column(name = "telefone", columnDefinition = "varchar(14)")
    private String telefone;
    
    @CPF(message = "É necessário conter um CPF válido.")
    @Column(name = "cpf", columnDefinition = "varchar(14)", nullable = false)
    private String cpf;
    
    @NotBlank(message = "O campo EMAIL é obrigatório.")
    @Email(message = "Deve conter um email válido.")
    @Column(name = "email", columnDefinition = "varchar(75)", nullable = false)
    private String email;

    public Cliente() {
        
    }
    
    public Cliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.idade = cliente.getIdade();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
