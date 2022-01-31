package com.olivetti.finance.service;

import com.olivetti.finance.model.Receita;
import com.olivetti.finance.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public void cadastraReceita(Receita receita) {
        if(!validaSeDescricaoExiste(receita)){
            receitaRepository.save(receita);
        }
    }

    public List<Receita> ListaReceitas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> detalhaReceitas(Long id) {
       return receitaRepository.findById(id);
    }

    public Receita atualizaReceitas(Receita receitaA) {
        if(!validaSeDescricaoExiste(receitaA)){
            Optional<Receita> receitaO=  receitaRepository.findById(receitaA.getId());
            Receita receita = receitaO.get();
            receita.setData(receitaA.getData());
            receita.setDescricao(receitaA.getDescricao());
            receita.setValor(receitaA.getValor());
            return receitaRepository.save(receita);
        }
        receitaA.setDescricao("não atualizado");
        return receitaA;
    }

    public void excluiReceitas(Long id) {
        receitaRepository.deleteById(id);
    }

    private Boolean validaSeDescricaoExiste(Receita receita) {
        Boolean resposta = true;
        Optional<List<Receita>>  ListaReceitas =  receitaRepository.buscaDescricao(receita.getDescricao());

        if(ListaReceitas.get().isEmpty()){
           return resposta = false;
        }
        return true;
    }


}
