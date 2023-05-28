package dev.yuri.lab.padroes.de.projeto.spring.service.impl;

import dev.yuri.lab.padroes.de.projeto.spring.exception.RegraDeNegocioException;
import dev.yuri.lab.padroes.de.projeto.spring.model.Cliente;
import dev.yuri.lab.padroes.de.projeto.spring.model.Endereco;
import dev.yuri.lab.padroes.de.projeto.spring.repository.ClienteRepository;
import dev.yuri.lab.padroes.de.projeto.spring.repository.EnderecoRepository;
import dev.yuri.lab.padroes.de.projeto.spring.service.IClienteService;
import dev.yuri.lab.padroes.de.projeto.spring.service.IViaCepService;
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
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private IViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por ID.
        return getClienteById(id);
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Cliente clienteEncontrado = getClienteById(id);
        atualizarCliente(cliente, clienteEncontrado);
        return clienteRepository.save(clienteEncontrado);
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }

    private Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new RegraDeNegocioException(
                        "O id: " + id + " não corresponde a nenhum cliente.",
                        new NullPointerException())
        );
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        Endereco endereco = getEndereco(cliente);
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        return clienteRepository.save(cliente);
    }

    private void atualizarCliente(Cliente cliente, Cliente clienteEncontrado) {
        Endereco novoEndereco = getEndereco(cliente);
        clienteEncontrado.setEndereco(novoEndereco);
        clienteEncontrado.setNome(cliente.getNome());
    }

    private Endereco getEndereco(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        return enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
    }
}
