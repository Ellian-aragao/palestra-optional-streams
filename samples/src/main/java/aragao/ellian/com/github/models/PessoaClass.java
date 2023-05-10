package aragao.ellian.com.github.models;

import java.util.Date;

public class PessoaClass {
    private final String nome;
    private final String cpf;
    private final Date dataDeNascimento;

    public static PessoaClass of(String nome, String cpf, Date dataDeNascimento) {
        return new PessoaClass(nome, cpf, dataDeNascimento);
    }
    public PessoaClass(String nome, String cpf, Date dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String nome() {
        return nome;
    }

    public String cpf() {
        return cpf;
    }

    public Date dataDeNascimento() {
        return dataDeNascimento;
    }
}
