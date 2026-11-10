// ALTERAR: pacote e nome do domínio.
package insper.prova.pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PessoaController {
  @Autowired private PessoaService service;
  // ALTERAR: rota da entidade.
  @GetMapping("/pessoas")
  public List<Pessoa> list() {
    return service.list();
  }
  // ALTERAR: rota da entidade.
  @GetMapping("/pessoas/{id}")
  public Pessoa get(@PathVariable int id) {
    return service.getById(id);
  }
  // ALTERAR: rota da entidade.
  @PostMapping("/pessoas")
  public Pessoa save(@Valid @RequestBody Pessoa p) {
    return service.save(p);
  }
  // ALTERAR: rota da entidade.
  @PutMapping("/pessoas/{id}")
  public Pessoa update(@PathVariable int id, @Valid @RequestBody Pessoa p) {
    p.setId(id);
    return service.save(p);
  }
  // ALTERAR: rota da entidade.
  @DeleteMapping("/pessoas/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
