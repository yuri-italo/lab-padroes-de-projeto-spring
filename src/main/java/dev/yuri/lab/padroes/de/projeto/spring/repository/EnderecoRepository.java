package dev.yuri.lab.padroes.de.projeto.spring.repository;

import dev.yuri.lab.padroes.de.projeto.spring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,String> {
}
