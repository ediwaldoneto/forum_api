package br.com.sbp1.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sbp1.forum.model.Usuario;
import br.com.sbp1.forum.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> uOptional = UsuarioRepository.findByEmail(username);
		if (uOptional.isPresent()) {
			return uOptional.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos!");
	}

	
}
