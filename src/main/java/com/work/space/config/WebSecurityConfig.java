package com.work.space.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.space.config.handler.MySimpleUrlAuthenticationSuccessHandler;
import com.work.space.service.OtpAuthenticationProvider;
import com.work.space.service.user.UserService;
import com.work.space.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final MySimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final UserService userService;
    private final OtpAuthenticationProvider otpAuthenticationProvider;
    private final ObjectMapper objectMapper;
//    @Autowired
    public WebSecurityConfig(

            MySimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler, CustomAuthenticationFailureHandler customAuthenticationFailureHandler, UserService userService,
                             OtpAuthenticationProvider otpAuthenticationProvider, ObjectMapper objectMapper) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
        this.userService = userService;
        this.otpAuthenticationProvider = otpAuthenticationProvider;
        this.objectMapper = objectMapper;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(otpAuthenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Доступ только для не зарегистрированных пользователей
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**", "/", "/resources/**", "/v3/api-docs/**",
                        "/swagger-ui/**").permitAll()
                 .antMatchers("/onetimecode").not().authenticated()
                 .antMatchers("/login").not().authenticated()
                .antMatchers("/registration-otp").not().authenticated()
                .antMatchers("/rest/users").not().authenticated()
                .antMatchers("/rest/**").authenticated()
                // Доступ только для пользователей с ролью Администратор
//                .antMatchers("/rest/admin").hasRole("ADMIN")/ fixme delete
                .antMatchers("/rest/admin/**").hasRole("ADMIN")
                // TODO разобраться
//                .antMatchers("/news").hasAnyAuthority("USER", "ADMIN")// почему то так не работает
                .antMatchers("/news").hasRole("USER")
//                .antMatchers("/counters").hasRole("USER")
                .antMatchers("/add-counter").hasRole("USER")
                .antMatchers("/saveCounter").hasRole("USER")
                .antMatchers("/upload").hasRole("USER")
                .antMatchers("/saveCounterValues").hasRole("USER")
                .antMatchers("/request").hasRole("USER")
                .antMatchers("/request/**").hasRole("USER")
                .antMatchers("/files/**").hasRole("USER")
                // Доступ разрешен всем пользователей
                .antMatchers("/version").permitAll()
                .and()
                 .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .logout()
                .permitAll().logoutSuccessUrl("/")
                .and()
                .logout().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .csrf().disable()
                .cors()
                // Перенаправление на главную страницу после успешного выхода
//                .defaultSuccessUrl("/").permitAll()
                .and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and()
        ;

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
    @PostConstruct
    void setMapper() {
        JsonUtil.setObjectMapper(objectMapper);
    }
}
