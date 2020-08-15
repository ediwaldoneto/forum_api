package br.com.sbp1.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sbp1.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
