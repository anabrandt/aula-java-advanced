package br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @NotBlank(message="{employee.name.notblank}")
    @Size(min=2, message="{employee.name.size}")
    private String name;
    
    @Email(message="{employee.email.email}")
    @NotBlank(message="{employee.email.notblank}")
    private String email;
}
