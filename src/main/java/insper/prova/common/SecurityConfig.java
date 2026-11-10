package insper.prova.common;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.*;
import java.util.Arrays;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter filter,
      @Qualifier("corsConfigurationSource") CorsConfigurationSource cors) throws Exception {
    return http.cors(c -> c.configurationSource(cors))
        .csrf(c -> c.disable())
        .headers(h -> h.frameOptions(f -> f.sameOrigin()))
        .authorizeHttpRequests(a
            -> a.requestMatchers(HttpMethod.OPTIONS, "/**")
                   .permitAll()
                   .requestMatchers(HttpMethod.POST, "/usuarios", "/login")
                   .permitAll()
                   .requestMatchers("/swagger-ui.html", "/h2-console/**", "/swagger-ui/**",
                       "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**")
                   .permitAll()
                   .anyRequest()
                   .authenticated())
        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration c = new CorsConfiguration();
    c.setAllowedOriginPatterns(Arrays.asList("*"));
    c.setAllowedMethods(Arrays.asList("*"));
    c.setAllowedHeaders(Arrays.asList("*"));
    c.setAllowCredentials(false);
    c.setMaxAge(3600L);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", c);
    return source;
  }
}
