package br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.dtos;

import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private Sexo sexo;
}
