package insper.prova.usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity(name = "tb_user")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  @NotBlank @Column(nullable = false, unique = true) private String email;
  @NotBlank @Column(nullable = false) private String senha;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
}
