package springPart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springPart.app.security.JwtUtil;
import springPart.model.AuthRequest;
import springPart.model.AuthResponse;
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
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getKorisnickoIme(), authRequest.getLozinka()));
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		}
		catch(BadCredentialsException e) {
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
		
		final UserDetails userDetails = serviceAuth.loadUserByUsername(authRequest.getKorisnickoIme());
		final String jwt = util.generateToken(userDetails);
	
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
}
