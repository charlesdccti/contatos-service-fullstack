package br.charles.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection="contato")
public class Contato {
	
	@Id
	private String id;

	@NotNull
	private String nome;
	
	@NotNull
	private String canal;
	
	@NotNull
	private String valor;
	
	private String obs;
}