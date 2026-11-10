// ALTERAR: pacote e entidade persistida.
package insper.prova.departamento;
import org.springframework.data.jpa.repository.JpaRepository;
// ALTERAR: classe da entidade e tipo do ID.
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {}
