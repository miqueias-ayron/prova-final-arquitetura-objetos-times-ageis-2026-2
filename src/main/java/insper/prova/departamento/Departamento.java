// ALTERAR: troque o pacote pelo nome da entidade equivalente na prova.
package insper.prova.departamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
// ALTERAR: nome da entidade JPA.
@Entity
public class Departamento {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
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
}
