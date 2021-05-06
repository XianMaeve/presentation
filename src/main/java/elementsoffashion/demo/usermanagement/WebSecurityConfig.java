package elementsoffashion.demo.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImplementation();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationSuccessHandlerImplementation authenticationSuccessHandlerImplementation;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //restrict console and all closets view to admin
                .antMatchers("/h2-console/**", "all-closets"
                ).hasRole("ADMIN")
                //restrict closet and add/delete functions to users.  Need to hide these options on views unless logged in.
                .antMatchers(
                        "/removeBottoms", "/deleteBottoms/**", "/addBottoms/**",
                        "/removeJacket", "/deleteJacket/**", "/addJackets/**",
                        "/removeShoes", "/deleteShoes/**", "/addShoes/**",
                        "/removeTops", "/deleteTops/**", "/addTops/**","addAccessoriesUser/**"
                ).access("hasRole('USER') or hasRole('ADMIN')")
                //other pages viewable without login
                .antMatchers("/css/**", "/js/**", "/images/**", "/index", "/user-registration", "/", "/all-accessories", "/accessories/**",
                        "/all-bottoms", "/bottoms/**", "/all-jackets", "/jackets/**", "/outfit", "/all-shoes", "/shoes/**", "/all-tops", "/tops/**","/addUser/**"
                        ).permitAll()
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and()
        .formLogin()
                .successHandler(authenticationSuccessHandlerImplementation)
                .loginPage("/login")
                .permitAll()
                .and()
        .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
        .csrf().disable()
        .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
}
