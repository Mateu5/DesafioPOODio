package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	private Set<Conteudo> cursosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> cursosConcluidos = new LinkedHashSet<>();
	
	public void inscreverBootCamp(BootCamp bootCamp) {
		this.cursosInscritos.addAll(bootCamp.getConteudos());
		bootCamp.getDevsInscritos().add(this);
		
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.cursosInscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			this.cursosConcluidos.add(conteudo.get());
			this.cursosInscritos.remove(conteudo.get());
		}else {
			System.err.println("voçê não esta matriculado em nenhum Curso!");
		}
	}
	
	public double calcularTotalXp() {
		return  this.cursosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getCursosInscritos() {
		return cursosInscritos;
	}

	public void setCursosInscritos(Set<Conteudo> cursosInscritos) {
		this.cursosInscritos = cursosInscritos;
	}

	public Set<Conteudo> getCursosConcluidos() {
		return cursosConcluidos;
	}

	public void setCursosConcluidos(Set<Conteudo> cursosConcluidos) {
		this.cursosConcluidos = cursosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cursosConcluidos, cursosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(cursosConcluidos, other.cursosConcluidos)
				&& Objects.equals(cursosInscritos, other.cursosInscritos) && Objects.equals(nome, other.nome);
	}
	
}
