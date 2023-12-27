package br.com.alura.java.spring.data.jpa.control.employees;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.java.spring.data.jpa.control.employees.service.CrudCargoService;
import br.com.alura.java.spring.data.jpa.control.employees.service.CrudFuncionarioService;
import br.com.alura.java.spring.data.jpa.control.employees.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class JavaSpringDataJpaApplication implements CommandLineRunner {

	private final CrudCargoService crudCargoService;
	private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
	private final CrudFuncionarioService crudFuncionarioService;
	private Boolean system = true;

	public JavaSpringDataJpaApplication(CrudCargoService crudCargoService,
			CrudUnidadeTrabalhoService crudUnidadeTrabalhoService, CrudFuncionarioService crudFuncionarioService) {
		this.crudCargoService = crudCargoService;
		this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
		this.crudFuncionarioService = crudFuncionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringDataJpaApplication.class, args);
	}

	@Override
	// Método da CommandLineRunner executado após o método main
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Escolha a ação:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade Trabalho");
			System.out.println("3 - Funcionário");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				crudCargoService.inicial(scanner);
				break;
			case 2:
				crudUnidadeTrabalhoService.inicial(scanner);
				break;
			case 3:
				crudFuncionarioService.inicial(scanner);
				break;
			default:
				system = false;
			}
		}

	}

}
