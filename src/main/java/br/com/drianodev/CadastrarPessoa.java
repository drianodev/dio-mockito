package br.com.drianodev;

import java.time.LocalDate;

public class CadastrarPessoa {

    private ApiCorreios apiCorreios;

    public CadastrarPessoa(final ApiCorreios apiDosCorreios) {
        this.apiCorreios = apiDosCorreios;
    }

    public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
        Pessoa pessoa = new Pessoa(nome, documento, nascimento);
        DadosLocalizacao dadosLocalizacao = apiCorreios.buscaDadosComBaseNoCep(cep);
        pessoa.adicionaDadosDeEndereco(dadosLocalizacao);
        return pessoa;
    }
}
