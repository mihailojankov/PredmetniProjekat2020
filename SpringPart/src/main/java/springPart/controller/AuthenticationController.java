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
import springPart.model.korisnikPart.RegistrovanKorisnik;
import springPart.model.security.AuthRequest;
import springPart.model.security.AuthResponse;
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
