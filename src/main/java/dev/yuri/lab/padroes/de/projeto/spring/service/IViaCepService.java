package dev.yuri.lab.padroes.de.projeto.spring.service;

import dev.yuri.lab.padroes.de.projeto.spring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client HTTP, criado via OpenFeign, para o consumo da API do ViaCEP.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author yuri-italo
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {

    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
