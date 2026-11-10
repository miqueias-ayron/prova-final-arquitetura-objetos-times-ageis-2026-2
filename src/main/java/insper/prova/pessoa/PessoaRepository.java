// ALTERAR: pacote e entidade persistida.
package insper.prova.pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
// ALTERAR: classe da entidade e tipo do ID.
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {}
