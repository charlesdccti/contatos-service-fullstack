package br.charles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.charles.model.Contato;
import br.charles.service.ContatoService;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	
	
	@GetMapping(value = "/{idContato}")
	public Contato getContato(@PathVariable Integer idContato) {
		return contatoService.getContato(String.valueOf(idContato));
	}
	
	
	@PutMapping(value = "/{idContato}")
	public Contato updateContato(@PathVariable Integer idContato, @RequestBody Contato contato) {
		return contatoService.updateContato(String.valueOf(idContato), contato);
	}

	
	@DeleteMapping(value = "/{idContato}")
	public Contato deleteContato(@PathVariable Integer idContato) {
		return contatoService.deleteContato(String.valueOf(idContato));
	}
	
	
	@PostMapping
	public Contato createContato(@RequestBody Contato contato) {
		return contatoService.createContato(contato);
	}
	
	
	@GetMapping(value = "/")
	Page<Contato> contatosPageable(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page, @ApiIgnore @PageableDefault(page = 0, size = 10) Pageable pageable) {
		return contatoService.listContatosByPage(pageable);
	}
	
	
}