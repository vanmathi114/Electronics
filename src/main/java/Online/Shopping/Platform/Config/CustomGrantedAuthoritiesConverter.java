package Online.Shopping.Platform.Config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomGrantedAuthoritiesConverter {

    private final JwtGrantedAuthoritiesConverter defaultConverter = new JwtGrantedAuthoritiesConverter();

    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Get the authorities from the JWT token
        Collection<GrantedAuthority> authorities = defaultConverter.convert(jwt);
        GrantedAuthority authority1 = new SimpleGrantedAuthority("admin");
        authorities.add(authority1);
//        return authorities;

        // Return authorities directly as your roles already don't have the 'ROLE_' prefix
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))  // No change needed if no prefix
                .collect(Collectors.toList());
    }
}
