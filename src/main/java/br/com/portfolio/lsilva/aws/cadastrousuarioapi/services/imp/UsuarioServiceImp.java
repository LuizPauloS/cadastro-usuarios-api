package br.com.portfolio.lsilva.aws.cadastrousuarioapi.services.imp;

import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.dtos.UsuarioDTO;
import br.com.portfolio.lsilva.aws.cadastrousuarioapi.domains.entities.Usuario;
import br.com.portfolio.lsilva.aws.cadastrousuarioapi.repositories.UsuarioRepository;
import br.com.portfolio.lsilva.aws.cadastrousuarioapi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = buildEntity(usuarioDTO);
        repository.save(usuario);
        return buildDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = repository.findAll();
        return buildDTOList(usuarios);
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        boolean usuarioEncontrado = usuarioOptional.isPresent();
        usuarioOptional.ifPresent(repository::delete);
        return usuarioEncontrado;
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        Usuario usuarioBD = usuarioOptional.get();
        Usuario usuarioRequest = buildEntity(usuarioDTO);
        merge(usuarioBD, usuarioRequest);
        repository.save(usuarioRequest);
        return buildDTO(usuarioRequest);
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        return buildDTO(usuarioOptional.get());
    }

    private Usuario buildEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) throw new RuntimeException("Erro ao buildar Usuário!");
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .cpf(usuarioDTO.getCpf())
                .email(usuarioDTO.getEmail())
                .sexo(usuarioDTO.getSexo())
                .dataNascimento(usuarioDTO.getDataNascimento())
                .build();
    }

    private UsuarioDTO buildDTO(Usuario usuario) {
        if (usuario == null) throw new RuntimeException("Erro ao buildar Usuário!");
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .sexo(usuario.getSexo())
                .dataNascimento(usuario.getDataNascimento())
                .build();
    }

    private List<UsuarioDTO> buildDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::buildDTO)
                .collect(Collectors.toList());
    }

    private Usuario merge(Usuario usuarioBD, Usuario usuarioRequest) {
        if (usuarioBD == null || usuarioRequest == null) throw new RuntimeException("Erro ao atualizar Usuário!");
        BeanUtils.copyProperties(usuarioRequest, usuarioBD);
        return usuarioRequest;
    }
}
