package com.Gateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//added manually
import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
public class SecurityConfig {

	@Bean
	SecurityWebFilterChain springApplicationWebFilterChain(ServerHttpSecurity serverHttpSecurity) {

		return
        serverHttpSecurity.authorizeExchange(
                exchanges -> exchanges
                        .pathMatchers(HttpMethod.POST, "/**").authenticated()
                        .pathMatchers(HttpMethod.PUT, "/**").authenticated()
                        .pathMatchers(HttpMethod.PATCH, "/**").authenticated()
                        .pathMatchers(HttpMethod.DELETE, "/**").authenticated()
                        .pathMatchers(HttpMethod.GET, "/**").permitAll())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .csrf(csrf->csrf.disable())
                .build();
		
		
	}
}
