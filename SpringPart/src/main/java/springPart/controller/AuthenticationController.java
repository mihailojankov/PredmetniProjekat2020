package springPart.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.net.httpserver.Authenticator.Success;

import springPart.app.security.JwtUtil;
import springPart.model.AuthRequest;
import springPart.model.AuthResponse;
import springPart.model.RegistrovanKorisnik;
import springPart.service.RegistrovanKorisnikService;

@Controller
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	RegistrovanKorisnikService serviceAuth;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		//Ako je admin
		if(authRequest.getKorisnickoIme().equals("admin") && authRequest.getLozinka().equals("admin123")) {
			
			
			
			final String jwt = util.generateToken(new UserDetails() {
				
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
					return authRequest.getKorisnickoIme();
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return authRequest.getLozinka();
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
			});
			
			AuthResponse response = new AuthResponse(jwt);
			
			return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
		}
		
		//Ako je non-admin
		else {
			
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getKorisnickoIme(), authRequest.getLozinka()));
				}
				catch(BadCredentialsException e) {
					return new ResponseEntity<AuthResponse>(HttpStatus.CONFLICT);
				}
			
			
			final UserDetails userDetails = serviceAuth.loadUserByUsername(authRequest.getKorisnickoIme());
			final String jwt = util.generateToken(userDetails);
			
			AuthResponse response = new AuthResponse(jwt);
		
			return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
		}
		
	}
}
