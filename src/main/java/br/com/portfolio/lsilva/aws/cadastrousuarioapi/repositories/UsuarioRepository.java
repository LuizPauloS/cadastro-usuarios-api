package br.com.portfolio.lsilva.aws.cadastrousuarioapi.repositories;

import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
