package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.java.spring.data.jpa.control.employees.repository.FuncionarioRepository;
import br.com.alura.java.spring.data.jpa.control.employees.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamicoService {

	private final FuncionarioRepository funcionarioRepository;

	public RelatorioFuncionarioDinamicoService(
			FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();

		funcionarioRepository.findAll(
				Specification.where(
						SpecificationFuncionario.nome(nome)));

	}

}
