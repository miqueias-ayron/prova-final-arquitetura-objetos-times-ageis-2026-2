package insper.prova.departamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Departamento {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
  @JsonIgnore
  @OneToMany(mappedBy = "departamento")
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
  public void setNome(String nome) {
    this.nome = nome;
  }
  public List<insper.prova.projeto.Projeto> getProjetos() {
    return projetos;
  }
  public void setProjetos(List<insper.prova.projeto.Projeto> projetos) {
    this.projetos = projetos;
  }
}
