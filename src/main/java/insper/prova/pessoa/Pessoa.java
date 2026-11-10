// ALTERAR: troque o pacote pelo nome da entidade equivalente na prova.
package insper.prova.pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
// ALTERAR: nome da entidade JPA.
@Entity
public class Pessoa {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
  @NotBlank(message = "CPF não pode ser vazio")
  @Column(nullable = false, unique = true)
  private String cpf;
  @JsonIgnore
  @ManyToMany(mappedBy = "pessoas")
  // ALTERAR: entidade relacionada e nome do atributo conforme a relação N:N da prova.
  private List<insper.prova.projeto.Projeto> projetos = new ArrayList<>();
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
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String c) {
    cpf = c;
  }
  public List<insper.prova.projeto.Projeto> getProjetos() {
    return projetos;
  }
  public void setProjetos(List<insper.prova.projeto.Projeto> p) {
    projetos = p;
  }
}
