package insper.prova.usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
