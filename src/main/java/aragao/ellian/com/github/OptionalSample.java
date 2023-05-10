package aragao.ellian.com.github;

import aragao.ellian.com.github.models.Pessoa;
import aragao.ellian.com.github.provider.PessoaProvider;

import javax.management.InvalidAttributeValueException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class OptionalSample {

    static Optional<Pessoa> findPessoa() {
        return PessoaProvider.getListPessoas().stream().findFirst();
    }

    static Optional<Pessoa> findPessoaEmpty() {
        return Optional.empty();
    }

    static String mapNomePessoaOrThrowError() {
        return findPessoa()
                .map(Pessoa::nome)
                .filter(nomePessoa -> !nomePessoa.isBlank())
                .orElseThrow();
    }

    static String flatMapNomePessoaOrThrowError() {
        return findPessoa()
                .flatMap(pessoa -> Optional.ofNullable(pessoa.nome()))
                .filter(nomePessoa -> !nomePessoa.isBlank())
                .orElseThrow();
    }

    static Pessoa processValidationsOfPessoa() throws InvalidAttributeValueException {
        return findPessoa()
                .filter(pessoa -> pessoa.cpf().matches("\\d"))
                .filter(pessoa -> !pessoa.nome().isBlank())
                .filter(pessoa -> Objects.nonNull(pessoa.dataDeNascimento()))
                .orElseThrow(() -> new InvalidAttributeValueException("O tipo Pessoa está com dados inválidos"));
    }

    static void processPessoaIfExists() {
        findPessoa().ifPresent(System.out::println);
    }

    static void processPessoaIfExistsOrElseShowNotExists() {
        findPessoa().ifPresentOrElse(
                System.out::println,
                () -> System.out.println("não existe pessoa")
        );
    }

    public static void main(String[] args) {
        final var map = Map.of();
        if (map.containsKey(1)) {
            final var value = map.get(1);
            System.out.println("contem o dado" + value);
        }
    }
}
