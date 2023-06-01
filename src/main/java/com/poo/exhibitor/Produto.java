package com.poo.exhibitor;


@Table(name = "produto")
@Entity(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE0)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco")
	private double preco;
	
	
	private Produto produto(String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	};
	
}
