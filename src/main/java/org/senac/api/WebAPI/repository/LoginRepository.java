package org.senac.api.WebAPI.repository;

import org.senac.api.WebAPI.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*
* @author Christian
*/

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
