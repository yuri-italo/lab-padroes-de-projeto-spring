package dev.yuri.lab.padroes.de.projeto.spring.service.impl;

import dev.yuri.lab.padroes.de.projeto.spring.model.Cliente;
import dev.yuri.lab.padroes.de.projeto.spring.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da Strategy {@link IClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um Singleton.
 *
 * @author yuri-italo
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por ID.
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
    }
}
