package br.com.sbp1.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.sbp1.forum.controller.dto.TopicoDto;
import br.com.sbp1.forum.model.Curso;
import br.com.sbp1.forum.model.Topico;
import br.com.sbp1.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {

	    List<Topico> topicos = topicoRepository.findAll();
		
		return TopicoDto.converter(topicos);
	}
}
