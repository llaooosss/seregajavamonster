//package com.example.cookies.configuration;
//
//
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//@Configuration
//@EnableWebSecurity
//public class KeyCloakConfiguration extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new NullAuthenticatedSessionStrategy();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        authManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Bean
//    public KeycloakConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                    .authorizeRequests()
//                        .antMatchers("/admin/**").hasRole("ADMIN")  // Доступ для администраторов
//                        .antMatchers("/user/**").hasRole("USER")    // Доступ для обычных пользователей
//                        .antMatchers("/login", "/register").permitAll() // Доступ к публичным страницам
//                    .and()
//                        .formLogin()
//                        .loginPage("/login") // Страница логина
//                        .loginProcessingUrl("/userloginvalidate") // URL для обработки логина
//                        .successHandler((request, response, authentication) -> {
//                            response.sendRedirect("/"); // Перенаправление после успешного входа
//                        })
//                        .failureHandler((request, response, exception) -> {
//                            response.sendRedirect("/login?error=true"); // Перенаправление при ошибке
//                        })
//                    .and()
//                        .logout()
//                        .logoutUrl("/logout") // URL для выхода
//                        .logoutSuccessUrl("/login") // Перенаправление после выхода
//                        .deleteCookies("JSESSIONID") // Удаление cookie
//                    .and()
//                        .exceptionHandling()
//                        .accessDeniedPage("/403")  // Страница ошибки доступа
//                    .and()
//                        .csrf().disable();  // Отключение CSRF (если необходимо)
//            super.configure(http);
//        }
//    }
