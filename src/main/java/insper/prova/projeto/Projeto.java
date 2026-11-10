// ALTERAR: troque o pacote pelo nome da entidade equivalente na prova.
package insper.prova.projeto;
import com.fasterxml.jackson.annotation.JsonIgnore;
// ALTERAR: classe importada conforme a entidade do lado da relação.
import insper.prova.departamento.Departamento;
// ALTERAR: classe importada conforme a entidade do lado da relação.
import insper.prova.pessoa.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
// ALTERAR: nome da entidade JPA.
@Entity
public class Projeto {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
  private String descricao;
  @NotNull(message = "Departamento é obrigatório")
  @ManyToOne
  // ALTERAR: cardinalidade, nome da coluna FK e entidade relacionada.
  @JoinColumn(name = "id_departamento", nullable = false)
  // ALTERAR: tipo e nome do atributo da entidade relacionada.
  private Departamento departamento;
  @ManyToMany
  // ALTERAR: cardinalidade N:N e nomes da tabela/colunas da tabela de associação.
  @JoinTable(name = "projeto_pessoa", joinColumns = @JoinColumn(name = "id_projeto"),
      inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
  // ALTERAR: tipo e nome da coleção do outro lado da relação N:N.
  private List<Pessoa> pessoas = new ArrayList<>();
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String n) {
    nome = n;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String d) {
    descricao = d;
  }
  public Departamento getDepartamento() {
    return departamento;
  }
  public void setDepartamento(Departamento d) {
    departamento = d;
  }
  public List<Pessoa> getPessoas() {
    return pessoas;
  }
  public void setPessoas(List<Pessoa> p) {
    pessoas = p;
  }
}
