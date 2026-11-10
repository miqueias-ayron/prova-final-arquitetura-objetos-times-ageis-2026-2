package insper.prova.projeto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProjetoController {
  @Autowired private ProjetoService service;
  @GetMapping("/projetos")
  public List<Projeto> list() {
    return service.list();
  }
  @GetMapping("/projetos/{id}")
  public Projeto get(@PathVariable int id) {
    return service.getById(id);
  }
  @PostMapping("/projetos")
  public Projeto save(@Valid @RequestBody Projeto p) {
    return service.save(p);
  }
  @PutMapping("/projetos/{id}")
  public Projeto update(@PathVariable int id, @Valid @RequestBody Projeto p) {
    p.setId(id);
    return service.save(p);
  }
  @DeleteMapping("/projetos/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
  @PostMapping("/projetos/{projetoId}/pessoas/{pessoaId}")
  public Projeto addPessoa(@PathVariable int projetoId, @PathVariable int pessoaId) {
    return service.addPessoa(projetoId, pessoaId);
  }
  @DeleteMapping("/projetos/{projetoId}/pessoas/{pessoaId}")
  public Projeto removePessoa(@PathVariable int projetoId, @PathVariable int pessoaId) {
    return service.removePessoa(projetoId, pessoaId);
  }
}
