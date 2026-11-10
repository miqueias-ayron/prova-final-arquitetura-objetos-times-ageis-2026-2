// ALTERAR: pacote e nome do domínio.
package insper.prova.projeto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProjetoController {
  @Autowired private ProjetoService service;
  // ALTERAR: rota da entidade.
  @GetMapping("/projetos")
  public List<Projeto> list() {
    return service.list();
  }
  // ALTERAR: rota da entidade.
  @GetMapping("/projetos/{id}")
  public Projeto get(@PathVariable int id) {
    return service.getById(id);
  }
  // ALTERAR: rota da entidade.
  @PostMapping("/projetos")
  public Projeto save(@Valid @RequestBody Projeto p) {
    return service.save(p);
  }
  // ALTERAR: rota da entidade.
  @PutMapping("/projetos/{id}")
  public Projeto update(@PathVariable int id, @Valid @RequestBody Projeto p) {
    p.setId(id);
    return service.save(p);
  }
  // ALTERAR: rota da entidade.
  @DeleteMapping("/projetos/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
  // ALTERAR: entidades, IDs e rota do vínculo N:N.
  @PostMapping("/projetos/{projetoId}/pessoas/{pessoaId}")
  public Projeto addPessoa(@PathVariable int projetoId, @PathVariable int pessoaId) {
    return service.addPessoa(projetoId, pessoaId);
  }
  // ALTERAR: entidades, IDs e rota do vínculo N:N.
  @DeleteMapping("/projetos/{projetoId}/pessoas/{pessoaId}")
  public Projeto removePessoa(@PathVariable int projetoId, @PathVariable int pessoaId) {
    return service.removePessoa(projetoId, pessoaId);
  }
}
