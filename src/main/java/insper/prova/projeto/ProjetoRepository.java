// ALTERAR: pacote e entidade persistida.
package insper.prova.projeto;
import org.springframework.data.jpa.repository.JpaRepository;
// ALTERAR: classe da entidade e tipo do ID.
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {}
