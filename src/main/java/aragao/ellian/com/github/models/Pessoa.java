package aragao.ellian.com.github.models;

import java.util.Date;

public record Pessoa(String nome, String cpf, Date dataDeNascimento) {

    public static Pessoa of(String nome, String cpf, Date dataDeNascimento) {
        return new Pessoa(nome, cpf, dataDeNascimento);
    }
}
