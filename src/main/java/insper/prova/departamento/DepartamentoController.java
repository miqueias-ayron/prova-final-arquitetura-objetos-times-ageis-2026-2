// ALTERAR: pacote e nome do domínio.
package insper.prova.departamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DepartamentoController {
  @Autowired private DepartamentoService service;
  // ALTERAR: rota da entidade.
  @GetMapping("/departamentos")
  public List<Departamento> list() {
    return service.list();
  }
  // ALTERAR: rota da entidade.
  @GetMapping("/departamentos/{id}")
  public Departamento get(@PathVariable int id) {
    return service.getById(id);
  }
  // ALTERAR: rota da entidade.
  @PostMapping("/departamentos")
  public Departamento save(@Valid @RequestBody Departamento d) {
    return service.save(d);
  }
  // ALTERAR: rota da entidade.
  @PutMapping("/departamentos/{id}")
  public Departamento update(@PathVariable int id, @Valid @RequestBody Departamento d) {
    d.setId(id);
    return service.save(d);
  }
  // ALTERAR: rota da entidade.
  @DeleteMapping("/departamentos/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
