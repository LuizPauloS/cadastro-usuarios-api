package br.com.portfolio.lsilva.aws.cadastrousuarioapi.services;

import java.util.List;

public interface BaseService<DTO> {

    DTO save(DTO entityDTO);

    List<DTO> findAll();

    Boolean delete(Integer id);

    DTO update(Integer id, DTO entityDTO);

    DTO findById(Integer id);
}
