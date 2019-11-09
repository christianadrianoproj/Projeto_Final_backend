package org.senac.api.WebAPI.repository;

import org.senac.api.WebAPI.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*
* @author Christian
*/

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
