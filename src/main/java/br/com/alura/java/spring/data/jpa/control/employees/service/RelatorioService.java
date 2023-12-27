package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;
import br.com.alura.java.spring.data.jpa.control.employees.repository.FuncionarioRepository;

@Service
public class RelatorioService {

	private final FuncionarioRepository funcionarioRepository;
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de relatório deseja executar? ");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionário por nome");
			System.out.println("2 - Busca funcionário por nome, salário maior e data contratação");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscarFuncionarioNome(scanner);
				break;
			case 2:
				buscarFuncionarioNomeSalarioMaiorDataContratacao(scanner);
				break;
			default:
				system = false;
				break;
			}
		}

	}

	public void buscarFuncionarioNome(Scanner scanner) {

		System.out.println("Nome do funcionário: ");
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(scanner.next());

		funcionarios.forEach(System.out::println);

	}

	public void buscarFuncionarioNomeSalarioMaiorDataContratacao(Scanner scanner) {

		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();

		System.out.println("Salário do funcionário: ");
		Double salario = scanner.nextDouble();

		System.out.println("Data de contração do funcionário: ");
		String dataContratacao = scanner.next();

		List<Funcionario> funcionarios = funcionarioRepository
				.findNomeSalarioMaiorDataContratacao(
						nome, salario, LocalDate.parse(dataContratacao, formatter));

		funcionarios.forEach(System.out::println);

	}

}
