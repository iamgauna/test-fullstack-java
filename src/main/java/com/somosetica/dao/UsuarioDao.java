package com.somosetica.dao;

import com.somosetica.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username); //Utilizamos QueryMethods de expring para que realice el "trabajo duro"
}
