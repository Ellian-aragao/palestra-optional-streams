package aragao.ellian.com.github;

import aragao.ellian.com.github.models.Pessoa;
import aragao.ellian.com.github.provider.PessoaProvider;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamSample {

    static void getListAndFlatmapStream() {
        Stream.of(PessoaProvider.getListPessoas())
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    static List<Date> validadePessoas() {
        return PessoaProvider.getListPessoas().stream()
                .filter(pessoa -> Objects.nonNull(pessoa.nome()))
                .filter(pessoa -> Objects.nonNull(pessoa.cpf()))
                .filter(pessoa -> !pessoa.cpf().isBlank())
                .filter(pessoa -> !pessoa.nome().isBlank())
                .map(Pessoa::dataDeNascimento)
                .toList();
    }

    static List<Date> validadePessoasEm1funcao() {
        return PessoaProvider.getListPessoas().stream()
                .filter(StreamSample::validadePessoaFull)
                .map(Pessoa::dataDeNascimento)
                .toList();
    }

    static boolean validadePessoaFull(Pessoa pessoa) {
        return Objects.nonNull(pessoa.nome())
                && Objects.nonNull(pessoa.cpf())
                && !pessoa.cpf().isBlank()
                && !pessoa.nome().isBlank();
    }
}
