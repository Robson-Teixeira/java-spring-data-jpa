package br.com.alura.java.spring.data.jpa.control.employees;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.java.spring.data.jpa.control.employees.service.CrudCargoService;

@SpringBootApplication
public class JavaSpringDataJpaApplication implements CommandLineRunner {

	private final CrudCargoService crudCargoService;
	private Boolean system = true;

	public JavaSpringDataJpaApplication(CrudCargoService crudCargoService) {
		this.crudCargoService = crudCargoService;
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

			int action = scanner.nextInt();

			if (action == 1)
				crudCargoService.inicial(scanner);
			else
				system = false;
		}

	}

}
