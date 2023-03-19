package br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.entities;

import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
