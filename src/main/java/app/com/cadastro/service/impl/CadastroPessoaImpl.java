package app.com.cadastro.service.impl;

import app.com.cadastro.exception.ResourceNotFoundException;
import app.com.cadastro.model.Nacionalidade;
import app.com.cadastro.model.Naturalidade;
import app.com.cadastro.model.Pessoa;
import app.com.cadastro.repository.CadastroPessoaRepository;
import app.com.cadastro.repository.NacionalidadeRepository;
import app.com.cadastro.repository.NaturalidadeRepository;
import app.com.cadastro.service.CadastroPessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Service
public class CadastroPessoaImpl implements CadastroPessoaService {

    @Autowired
    private CadastroPessoaRepository cadastroPessoaRepository;

    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    @Autowired
    private NaturalidadeRepository naturalidadeRepository;

    @Override
    public Page<Pessoa> listarTodasPessoas(int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size);
        return cadastroPessoaRepository.findAllBy(pageRequest);
    }

    @Override
    public List<Nacionalidade> listarTodosPais() {
        return this.nacionalidadeRepository.findAll();
    }

    @Override
    public List<Naturalidade> listarTodosEstados() {
        return this.naturalidadeRepository.findAll();
    }

    @Override
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa) {
        Pessoa cadastroPessoaSalvo = cadastroPessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroPessoaSalvo);
    }

    @Override
    public Pessoa buscarPorPessoa(@PathVariable("codigo") Long codigo) throws ResourceNotFoundException {
        Pessoa cadastroPessoa = cadastroPessoaRepository.findById(codigo).orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado para esse codigo" + codigo));
        if(isNull(cadastroPessoa)) {
            throw new EmptyResultDataAccessException(1);
        }
        return cadastroPessoa;
    }

    @Override
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("codigo") Long codigo, @RequestBody @Valid Pessoa pessoaDetalhe) throws ResourceNotFoundException {
        Pessoa cadastroPessoa = buscarPorPessoa(codigo);
        BeanUtils.copyProperties(pessoaDetalhe, cadastroPessoa, "codigo");
        Pessoa salvarPessoa = cadastroPessoaRepository.save(cadastroPessoa);
        return ResponseEntity.status(HttpStatus.OK).body(salvarPessoa);
    }

    @Override
    public Map<String, Boolean> deletarPessoa(@PathVariable("codigo") Long codigo) throws ResourceNotFoundException {
        Pessoa cadastroPessoa = cadastroPessoaRepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrado para esse codigo " + codigo));
        cadastroPessoaRepository.delete(cadastroPessoa);
        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Pessoa deletado com sucesso!", Boolean.TRUE);
        return resposta;
    }
}
