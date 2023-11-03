package com.example.demo.controller;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/userdata/new").permitAll() //matchi  /api/demo päring, permitAll() lubab neid ilma securityta accessida
                        .anyRequest().authenticated() // kõik ülejäänud endpointid nõuavad autentimist
                ).formLogin(form -> form //kasutame form põhist autentimist
                        .loginProcessingUrl("/api/login") //endpoint mille pihta saadame login andmed on /api/login
                        .successHandler((request, response, authentication) -> {}) //successi puhul ei tee midagi erilist ja tagastame kasutajale 200 OK
                        .failureHandler(new AuthenticationEntryPointFailureHandler(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))) // failire puhul saadame kasutajale 401
                ).csrf((AbstractHttpConfigurer::disable)); //keelame crsfi
        return http.build();
    }
    @Bean
    public static PasswordEncoder passwordEncoder() { //loome encoderi, et paroolid ei oleks plaintext mälus
        return new BCryptPasswordEncoder(); //kasutame BCrypt hashimist
    }
}

/*
package com.example.demo.controller;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> {

                    authorize.requestMatchers("/**").permitAll();
                    //authorize.requestMatchers("/api/demo/users/new").permitAll();
                    //authorize.requestMatchers("/api/demo/users/email").permitAll();
                    authorize.anyRequest().authenticated();
                }).formLogin( // töötab Content-Type: multipart/form-data vs Controller application/json
                        form -> form
                                .loginPage("/login-user")
                                .loginProcessingUrl("/api/demo/userdata/email")
                                .defaultSuccessUrl("/my-films")
                                .successHandler((request, response, authentication) -> {
                                    System.out.println(authentication);
                                })
                                .failureHandler(new AuthenticationEntryPointFailureHandler
                                        (new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                );

        return http.build();
    }
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}

 */
