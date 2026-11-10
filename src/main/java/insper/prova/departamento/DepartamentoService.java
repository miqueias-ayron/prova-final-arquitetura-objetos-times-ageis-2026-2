// ALTERAR: pacote e nome do domínio.
package insper.prova.departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartamentoService {
  // ALTERAR: repository da entidade.
  @Autowired private DepartamentoRepository repository;
  public List<Departamento> list() {
    return repository.findAll();
  }
  public Departamento save(Departamento d) {
    return repository.save(d);
  }
  public Departamento getById(int id) {
    return repository.findById(id).orElseThrow(
        // ALTERAR: mensagem e entidade procurada.
        () -> new RuntimeException("Departamento não encontrado"));
  }
  public void delete(int id) {
    repository.delete(getById(id));
  }
}
