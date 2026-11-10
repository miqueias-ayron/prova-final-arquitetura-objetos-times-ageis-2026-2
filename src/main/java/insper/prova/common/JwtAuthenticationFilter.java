package insper.prova.common;
import insper.prova.usuario.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired private JwtService jwtService;
  @Autowired private UsuarioService usuarioService;
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws ServletException, IOException {
    String header = request.getHeader("Authorization");
    if (header != null && header.startsWith("Bearer ")) {
      String token = header.substring(7);
      try {
        String username = jwtService.extractUsername(token);
        if (SecurityContextHolder.getContext().getAuthentication() == null
            && jwtService.isTokenValid(token)) {
          UserDetails details = usuarioService.loadUserByUsername(username);
          SecurityContextHolder.getContext().setAuthentication(
              new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities()));
        }
      } catch (Exception ignored) {
      }
    }
    chain.doFilter(request, response);
  }
}
