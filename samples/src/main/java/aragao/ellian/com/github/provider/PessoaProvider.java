package aragao.ellian.com.github.provider;

import aragao.ellian.com.github.models.Pessoa;

import java.util.Date;
import java.util.List;

public class PessoaProvider {

    public static List<Pessoa> getListPessoas() {
        return List.of(
                Pessoa.of("beltrano", "000.000.000-00", new Date()),
                Pessoa.of("ciclano", "111.111.111-11", new Date()),
                Pessoa.of("Romário", "222.222.222-22", new Date()),
                Pessoa.of("vigotsky", "333.333.333-33", new Date()),
                Pessoa.of("socrates", "444.444.444-44", new Date()),
                Pessoa.of("baskara", "555.555.555-55", new Date()),
                Pessoa.of("pitagoras", "666.666.666-66", new Date()),
                Pessoa.of("sartre", "777.777.777-77", new Date()),
                Pessoa.of("platão", "888.888.888-88", new Date()),
                Pessoa.of("herastostenes", "999.999.999-99", new Date())
        );
    }
}
