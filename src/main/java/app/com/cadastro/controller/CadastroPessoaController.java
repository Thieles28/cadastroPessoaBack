package app.com.cadastro.controller;

import app.com.cadastro.exception.ResourceNotFoundException;
import app.com.cadastro.model.Nacionalidade;
import app.com.cadastro.model.Naturalidade;
import app.com.cadastro.model.Pessoa;
import app.com.cadastro.service.impl.CadastroPessoaImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("pessoa")
public class CadastroPessoaController {

    @Autowired
    private CadastroPessoaImpl cadastroPessoaImpl;

    @ApiOperation("Listar todas as pessoas cadastrada na base de dados")
    @GetMapping
    public Page<Pessoa> listarPessoa(@RequestParam(
            value = "page",
            required = false,
            defaultValue = "0") int page,
                                     @RequestParam(
                                             value = "size",
                                             required = false,
                                             defaultValue = "10") int size) {
        return cadastroPessoaImpl.listarTodasPessoas(page, size);
    }

    @ApiOperation("Listar todas os país na base de dados")
    @GetMapping("pais")
    public List<Nacionalidade> listarPais() {
        return cadastroPessoaImpl.listarTodosPais();
    }

    @ApiOperation("Listar todas os estados na base de dados")
    @GetMapping("estados")
    public List<Naturalidade> listarEstados() {
        return cadastroPessoaImpl.listarTodosEstados();
    }


    @ApiOperation("Buscar um única pessoa cadastrada na base de dados")
    @GetMapping("{codigo}")
    public Pessoa buscarPorPessoa(@PathVariable(value = "codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        return cadastroPessoaImpl.buscarPorPessoa(codigoEmpregado);
    }

    @ApiOperation("Cadastrar pessoas na base de dados")
    @PostMapping("cadastrar")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa cadastro) {
        return cadastroPessoaImpl.cadastrarPessoa(cadastro);
    }

    @ApiOperation("Atualizar pessoa na base de dados")
    @PutMapping("{codigo}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable(value = "codigo") Long codigo, @Valid @RequestBody Pessoa cadastro)
            throws ResourceNotFoundException {
        return cadastroPessoaImpl.atualizarPessoa(codigo, cadastro);
    }

    @ApiOperation("Remover uma pessoa da base de dados")
    @DeleteMapping("{codigo}")
    public Map<String, Boolean> removerPessoa(@PathVariable(value = "codigo") Long codigo) throws ResourceNotFoundException {
        Map<String, Boolean> resposta = cadastroPessoaImpl.deletarPessoa(codigo);
        return resposta;
    }
}
