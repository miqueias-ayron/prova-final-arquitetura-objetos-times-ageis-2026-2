package insper.prova.departamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DepartamentoController {
  @Autowired private DepartamentoService service;
  @GetMapping("/departamentos")
  public List<Departamento> list() {
    return service.list();
  }
  @GetMapping("/departamentos/{id}")
  public Departamento get(@PathVariable int id) {
    return service.getById(id);
  }
  @PostMapping("/departamentos")
  public Departamento save(@Valid @RequestBody Departamento d) {
    return service.save(d);
  }
  @PutMapping("/departamentos/{id}")
  public Departamento update(@PathVariable int id, @Valid @RequestBody Departamento d) {
    d.setId(id);
    return service.save(d);
  }
  @DeleteMapping("/departamentos/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
