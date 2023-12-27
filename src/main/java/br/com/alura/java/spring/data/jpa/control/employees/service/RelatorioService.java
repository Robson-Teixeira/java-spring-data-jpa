package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;
import br.com.alura.java.spring.data.jpa.control.employees.repository.FuncionarioRepository;

@Service
public class RelatorioService {

	private final FuncionarioRepository funcionarioRepository;
	private Boolean system = true;

	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de relatório deseja executar? ");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionário por nome");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscarFuncionarioNome(scanner);
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

}
