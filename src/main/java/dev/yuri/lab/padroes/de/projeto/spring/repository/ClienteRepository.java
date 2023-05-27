package dev.yuri.lab.padroes.de.projeto.spring.repository;

import dev.yuri.lab.padroes.de.projeto.spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
