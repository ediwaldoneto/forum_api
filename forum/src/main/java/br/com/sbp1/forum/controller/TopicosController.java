package br.com.sbp1.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.sbp1.forum.controller.dto.TopicoDto;
import br.com.sbp1.forum.model.Curso;
import br.com.sbp1.forum.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {

		Topico topico = new Topico("AAAAAAAAAAAA", "Instalação do  Spring", new Curso("Spring", "Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico));
	}
}
