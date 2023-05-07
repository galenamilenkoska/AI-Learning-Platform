package uikt.project.webapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService users) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/", "/home", "/login", "/register").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/admin/**").hasRole("ADMIN"))
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
                .rememberMe(rememberMe -> rememberMe.userDetailsService(users));

        return http.build();

    }

}
