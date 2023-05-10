package aragao.ellian.com.github;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionalSampleTest {

    @Test
    void teste() {
        final var pessoaEmpty = OptionalSample.findPessoaEmpty();
        assertTrue(pessoaEmpty.isEmpty());
    }

}
