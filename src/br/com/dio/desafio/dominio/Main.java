package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Python");
		curso1.setDescricao("Curso voltado para Ciência de dados");
		curso1.setCargaHoraria(20);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("HTML e CSS");
		curso2.setDescricao("UI ");
		curso2.setCargaHoraria(20);
		
		BootCamp bootcamp = new BootCamp();
		bootcamp.setNome("Python");
		bootcamp.setDescricao("Intensivo de Python");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		
		Dev mateus = new Dev();
		mateus.setNome("Mateus");
		mateus.inscreverBootCamp(bootcamp);
		System.out.println("Conteudos inscritos Mateus " + mateus.getCursosInscritos());
		
		Dev david = new Dev();
		david.setNome("David");
		david.inscreverBootCamp(bootcamp);
		System.out.println("Conteudos inscritos David " + david.getCursosInscritos());
		
	}

}
