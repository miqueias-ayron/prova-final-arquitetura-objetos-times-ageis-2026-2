// ALTERAR: troque o pacote pelo nome da entidade equivalente na prova.
package insper.prova.pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
// ALTERAR: nome da entidade JPA.
@Entity
public class Pessoa {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
  @NotBlank(message = "CPF não pode ser vazio")
  @Column(nullable = false, unique = true)
  private String cpf;
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
}
