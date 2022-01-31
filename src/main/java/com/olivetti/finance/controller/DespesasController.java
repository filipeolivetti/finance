package com.olivetti.finance.controller;

import com.olivetti.finance.model.Despesa;
import com.olivetti.finance.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
     public void cadastrar(@RequestBody @Valid Despesa despesa){
        despesaService.cadastrar(despesa);
     }

    @GetMapping
    public List<Despesa> listar(){
       return despesaService.listaDespesas();
    }

    @GetMapping("/detalhar/{id}")
    public Optional<Despesa> detalhar (@PathVariable @NotNull Long id){
        return despesaService.detalhaDespesa(id);
    }

    @PutMapping
    public Despesa atualizar(@RequestBody  @Valid Despesa despesaA){
       return despesaService.atualizaDespesa(despesaA);
    }

    @DeleteMapping
    public void excluir(@PathVariable @NotNull Long id){
        despesaService.excluirDespesa(id);
    }




}
