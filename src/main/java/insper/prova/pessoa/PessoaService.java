package insper.prova.pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PessoaService {
  @Autowired private PessoaRepository repository;
  public List<Pessoa> list() {
    return repository.findAll();
  }
  public Pessoa save(Pessoa p) {
    return repository.save(p);
  }
  public Pessoa getById(int id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
  }
  public void delete(int id) {
    repository.delete(getById(id));
  }
}
