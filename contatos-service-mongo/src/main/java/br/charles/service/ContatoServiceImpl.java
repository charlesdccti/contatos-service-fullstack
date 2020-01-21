package br.charles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.charles.model.Contato;
import br.charles.repository.ContatoRepository;



@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@SuppressWarnings("finally")
	private Contato findOne(String Id) {
		Contato instance = null;
		try {
			List<Contato> contatoList = contatoRepository.findAll();
			for (Contato contato : contatoList) {
				if (contato.getId().equals(Id)) {
					instance = contato;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return instance;
		}
	}

	@Override
	public Contato createContato(Contato contato) {
		return contatoRepository.save(contato);
	}

	@Override
	public List<Contato> listContatos() {
		return contatoRepository.findAll();
	}


	@Override
	public Contato updateContato(String id, Contato contato) {
		Contato updateInstance = this.findOne(id);
		if(updateInstance != null)
			updateInstance.setNome(contato.getNome());
		else {
			return null;
		}
		return contatoRepository.save(updateInstance);
	}


	@Override
	public Contato deleteContato(String id) {
		Contato instance = findOne(id);
		contatoRepository.delete(instance);
		return instance;
	}


	@Override
	public Contato getContato(String id) {
		return this.findOne(id);
	}

	
	@Override
	public Page<Contato> listContatosByPage(Pageable pageable) {
		return contatoRepository.findAll(pageable);
	}
	

}