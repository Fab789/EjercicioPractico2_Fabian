

package com.example.cine;

import com.example.cine.service.Impl.UsuarioServiceImpl;
import com.example.cine.Domain.Usuario;
import com.example.cine.DAO.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
     @Autowired
    private UsuarioDAO usuarioDAO;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Usuario usuario = usuarioDAO.findByUsername(username);
            if (usuario == null) throw new RuntimeException("Usuario no encontrado");
            return org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getnombre())
                    .password(usuario.getcontraseña())
                    .roles(usuario.getRol())
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/", "/contacto", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/peliculas/**", "/usuarios/**").hasRole("ADMIN")
                .requestMatchers("/reservas/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .permitAll();

        return http.build();
    }

}
