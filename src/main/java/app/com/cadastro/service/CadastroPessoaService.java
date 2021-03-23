package app.com.cadastro.service;

import app.com.cadastro.exception.ResourceNotFoundException;
import app.com.cadastro.model.Nacionalidade;
import app.com.cadastro.model.Naturalidade;
import app.com.cadastro.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public interface CadastroPessoaService {
    Page<Pessoa> listarTodasPessoas(int page, int size);
    List<Nacionalidade> listarTodosPais();
    List<Naturalidade> listarTodosEstados();
    ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa);
    Pessoa buscarPorPessoa(@PathVariable("codigo") Long codigo) throws ResourceNotFoundException;
    ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("codigo") Long codigo, @RequestBody @Valid Pessoa pessoaDetalhe) throws ResourceNotFoundException;
    Map<String, Boolean> deletarPessoa(@PathVariable("codigo") Long codigo) throws ResourceNotFoundException;
}
