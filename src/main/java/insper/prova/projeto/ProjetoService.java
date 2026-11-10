// ALTERAR: pacote e nome do domínio.
package insper.prova.projeto;
// ALTERAR: serviço da entidade do lado 1:N.
import insper.prova.departamento.*;
// ALTERAR: serviço da entidade do lado N:N.
import insper.prova.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ProjetoService {
  @Autowired private ProjetoRepository repository;
  // ALTERAR: serviço e entidade relacionados pela cardinalidade 1:N.
  @Autowired private DepartamentoService departamentoService;
  // ALTERAR: serviço e entidade relacionados pela cardinalidade N:N.
  @Autowired private PessoaService pessoaService;
  public List<Projeto> list() {
    return repository.findAll();
  }
  public Projeto getById(int id) {
    // ALTERAR: mensagem e entidade procurada.
    return repository.findById(id).orElseThrow(
        () -> new RuntimeException("Projeto não encontrado"));
  }
  public Projeto save(Projeto p) {
    // ALTERAR: validação do relacionamento obrigatório e nome do getter.
    if (p.getDepartamento() == null)
      throw new RuntimeException("Departamento é obrigatório");
    // ALTERAR: serviço, getter e setter conforme a relação da prova.
    p.setDepartamento(departamentoService.getById(p.getDepartamento().getId()));
    return repository.save(p);
  }
  public void delete(int id) {
    repository.delete(getById(id));
  }
  @Transactional
  // ALTERAR: entidades, IDs e coleção conforme a relação N:N da prova.
  public Projeto addPessoa(int projetoId, int pessoaId) {
    Projeto p = getById(projetoId);
    Pessoa pessoa = pessoaService.getById(pessoaId);
    if (!p.getPessoas().contains(pessoa))
      p.getPessoas().add(pessoa);
    if (!pessoa.getProjetos().contains(p))
      pessoa.getProjetos().add(p);
    return repository.save(p);
  }
  @Transactional
  // ALTERAR: entidades, IDs e coleção conforme a relação N:N da prova.
  public Projeto removePessoa(int projetoId, int pessoaId) {
    Projeto p = getById(projetoId);
    Pessoa pessoa = pessoaService.getById(pessoaId);
    p.getPessoas().remove(pessoa);
    pessoa.getProjetos().remove(p);
    return repository.save(p);
  }
}
