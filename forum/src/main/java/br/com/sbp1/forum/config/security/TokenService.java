package br.com.sbp1.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.sbp1.forum.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;

	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date atual = new Date();
		Date dataExpiracao = new Date(atual.getTime() + Long.parseLong(expiration));
		return Jwts.builder().setIssuer("API do Forum").setSubject(logado.getId().toString()).setIssuedAt(atual)
				.setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
