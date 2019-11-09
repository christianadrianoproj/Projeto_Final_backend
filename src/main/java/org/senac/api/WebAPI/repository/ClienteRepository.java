package org.senac.api.WebAPI.repository;

import org.senac.api.WebAPI.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*
* @author Christian
*/

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
