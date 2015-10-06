package pe.com.implast.security.filters;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
			/** username  password **/
			String username = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();
	    
	 return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
