package com.github.paintxd.locadora.repository;

import com.github.paintxd.locadora.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
