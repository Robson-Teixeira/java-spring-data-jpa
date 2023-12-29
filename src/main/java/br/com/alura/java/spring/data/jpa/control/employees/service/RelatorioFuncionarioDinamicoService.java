package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;
import br.com.alura.java.spring.data.jpa.control.employees.repository.FuncionarioRepository;
import br.com.alura.java.spring.data.jpa.control.employees.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamicoService {

	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamicoService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();

		if (nome.equalsIgnoreCase("NULL"))
			nome = null;

		System.out.println("CPF do funcionário: ");
		String cpf = scanner.next();

		if (cpf.equalsIgnoreCase("NULL"))
			cpf = null;

		System.out.println("Salário do funcionário: ");
		Double salario = scanner.nextDouble();

		if (salario == 0)
			salario = null;

		System.out.println("Data de contratação do funcionário: ");
		String data = scanner.next();

		LocalDate datacontratacao;

		if (data.equalsIgnoreCase("NULL"))
			datacontratacao = null;
		else
			datacontratacao = LocalDate.parse(data, formatter);

		List<Funcionario> funcionarios = funcionarioRepository.findAll(
				Specification.where(
						SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.datacontratacao(datacontratacao)));

		funcionarios.forEach(System.out::println);

	}

}
