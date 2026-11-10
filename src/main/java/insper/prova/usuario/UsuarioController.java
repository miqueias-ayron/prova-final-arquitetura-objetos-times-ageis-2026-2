package insper.prova.usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UsuarioController {
  @Autowired private UsuarioService usuarioService;
  @PostMapping("/usuarios")
  public User createUser(@Valid @RequestBody User user) {
    return usuarioService.create(user);
  }
  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest request) {
    return usuarioService.login(request);
  }
}
