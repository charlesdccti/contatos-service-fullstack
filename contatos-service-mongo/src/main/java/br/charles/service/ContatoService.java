package br.charles.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.charles.model.Contato;

public interface ContatoService {
	
	Contato createContato(Contato contato);
	Contato updateContato(String id, Contato contato);
	Contato deleteContato(String id);
	Contato getContato(String id);
	List<Contato> listContatos();

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Contato> listContatosByPage(Pageable pageable);
	

}