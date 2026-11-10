package insper.prova.projeto;
import insper.prova.departamento.*;
import insper.prova.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ProjetoService {
  @Autowired private ProjetoRepository repository;
  @Autowired private DepartamentoService departamentoService;
  @Autowired private PessoaService pessoaService;
  public List<Projeto> list() {
    return repository.findAll();
  }
  public Projeto getById(int id) {
    return repository.findById(id).orElseThrow(
        () -> new RuntimeException("Projeto não encontrado"));
  }
  public Projeto save(Projeto p) {
    if (p.getDepartamento() == null)
      throw new RuntimeException("Departamento é obrigatório");
    p.setDepartamento(departamentoService.getById(p.getDepartamento().getId()));
    return repository.save(p);
  }
  public void delete(int id) {
    repository.delete(getById(id));
  }
  @Transactional
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
  public Projeto removePessoa(int projetoId, int pessoaId) {
    Projeto p = getById(projetoId);
    Pessoa pessoa = pessoaService.getById(pessoaId);
    p.getPessoas().remove(pessoa);
    pessoa.getProjetos().remove(p);
    return repository.save(p);
  }
}
