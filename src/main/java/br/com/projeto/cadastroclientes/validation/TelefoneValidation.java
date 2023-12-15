/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.cadastroclientes.validation;

import br.com.projeto.cadastroclientes.validation.constraints.Telefone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 *
 * @author Pedro
 */
public class TelefoneValidation implements ConstraintValidator<Telefone, String>{

    @Override
    public void initialize(Telefone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        String telefone = t == null ? "" : t;
        return telefone.matches("^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$");
    }
    
}
