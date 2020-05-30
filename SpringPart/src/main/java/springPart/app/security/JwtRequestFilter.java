package springPart.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
			UserDetails ud = this.service.loadUserByUsername(korisnickoIme);
			
			if(util.validateToken(jwt, ud)) {
				
				UsernamePasswordAuthenticationToken uapToken = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
				System.out.println(ud.getAuthorities());
				uapToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uapToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
