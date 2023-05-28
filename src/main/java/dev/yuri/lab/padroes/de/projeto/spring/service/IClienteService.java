package dev.yuri.lab.padroes.de.projeto.spring.service;

import dev.yuri.lab.padroes.de.projeto.spring.model.Cliente;

/**
 * Interface que define o padrão Strategy no domínio de cliente.
 * Com isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author yuri-italo
 */
public interface IClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(Cliente cliente);

    Cliente atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
