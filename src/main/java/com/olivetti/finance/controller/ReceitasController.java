package com.olivetti.finance.controller;

import com.olivetti.finance.model.Receita;
import com.olivetti.finance.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Receita receita){
        receitaService.cadastraReceita(receita);
    }

    @GetMapping
    public List<Receita> listar(){
       return receitaService.ListaReceitas();
    }

    @GetMapping("/detalhar/{id}")
    public Optional<Receita> detalhar(@PathVariable @NotNull Long id){
       return  receitaService.detalhaReceitas(id);
    }

    @PutMapping
    public Receita atualizar(@RequestBody Receita receita){
        return receitaService.atualizaReceitas(receita);
    }

    @DeleteMapping
    public void excluir(@PathVariable @NotNull Long id){
        receitaService.excluiReceitas(id);
    }
}
