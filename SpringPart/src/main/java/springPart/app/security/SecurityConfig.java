package springPart.app.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import springPart.service.RegistrovanKorisnikService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private RegistrovanKorisnikService service;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
			.disable()
			.cors().and()
			.authorizeRequests()
			.antMatchers("/authenticate").permitAll()
			.antMatchers(HttpMethod.GET, "/fakultet/**", "/univerzitet/**", "/smerFakulteta/**", "/predmet/**").permitAll()
			.antMatchers(HttpMethod.GET, "/rok/**").hasAnyAuthority("STUDENT", "ADMIN", "CLAN")
			.antMatchers(HttpMethod.POST, "/registrovanKorisnik").permitAll()
			.antMatchers("/student/**", "/registrovanKorisnik/**").hasAnyAuthority("CLAN", "ADMIN")
			.antMatchers("/nastavnik/**","/clanAdministrativnogOsoblja/**").hasAuthority("ADMIN")
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		
		
		return super.authenticationManagerBean();
		
		
	}
}
