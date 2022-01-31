package com.olivetti.finance.service;

import com.olivetti.finance.model.Despesa;
import com.olivetti.finance.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public void cadastrar(Despesa despesa) {
        despesaRepository.save(despesa);
    }

    public List<Despesa> listaDespesas() {
        return despesaRepository.findAll();
    }

    public Optional<Despesa> detalhaDespesa(Long id) {
        return despesaRepository.findById(id);
    }

    public Despesa atualizaDespesa(Despesa despesaA) {
        Optional<Despesa> despesaUp = despesaRepository.findById(despesaA.getId());
        Despesa despesa = despesaUp.get();
        despesa.setData(despesaA.getData());
        despesa.setValor(despesaA.getValor());
        despesa.setDescricao(despesaA.getDescricao());
        despesaRepository.save(despesa);
        return despesa;
    }

    public void excluirDespesa(Long id) {
        despesaRepository.deleteById(id);
    }
}
