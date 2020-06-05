package springPart.app.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import springPart.service.RegistrovanKorisnikService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private RegistrovanKorisnikService service;
	
	@Autowired
	private JwtUtil util;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		
		String korisnickoIme = null;
		String jwt = null;
		
		if(authorizationHeader != null) {
			jwt = authorizationHeader;
			korisnickoIme = util.extractUsername(jwt);
		}
		
		if(korisnickoIme != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails ud;
			
			if(korisnickoIme.equals("admin")){
				ud = new UserDetails() {
					
					@Override
					public boolean isEnabled() {
						// TODO Auto-generated method stub
						return true;
					}
					
					@Override
					public boolean isCredentialsNonExpired() {
						// TODO Auto-generated method stub
						return true;
					}
					
					@Override
					public boolean isAccountNonLocked() {
						// TODO Auto-generated method stub
						return true;
					}
					
					@Override
					public boolean isAccountNonExpired() {
						// TODO Auto-generated method stub
						return true;
					}
					
					@Override
					public String getUsername() {
						// TODO Auto-generated method stub
						return "admin";
					}
					
					@Override
					public String getPassword() {
						// TODO Auto-generated method stub
						return "admin123";
					}
					
					@Override
					public Collection<? extends GrantedAuthority> getAuthorities() {
						ArrayList<GrantedAuthority> listaAuth = new ArrayList<GrantedAuthority>();
						GrantedAuthority admin = new GrantedAuthority() {
							
							@Override
							public String getAuthority() {
								return "ADMIN";
							}
						};
						
						listaAuth.add(admin);
						
						return listaAuth;
					}
				};
					
			}
			else {
				 ud = this.service.loadUserByUsername(korisnickoIme);
			}
			
			
			if(util.validateToken(jwt, ud)) {
				
				UsernamePasswordAuthenticationToken uapToken = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
				uapToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uapToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
