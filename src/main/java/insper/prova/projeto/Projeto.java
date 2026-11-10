package insper.prova.projeto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import insper.prova.departamento.Departamento;
import insper.prova.pessoa.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Projeto {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
  private String descricao;
  @NotNull(message = "Departamento é obrigatório")
  @ManyToOne
  @JoinColumn(name = "id_departamento", nullable = false)
  private Departamento departamento;
  @ManyToMany
  @JoinTable(name = "projeto_pessoa", joinColumns = @JoinColumn(name = "id_projeto"),
      inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
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
