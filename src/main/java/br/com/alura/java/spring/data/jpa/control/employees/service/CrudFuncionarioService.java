package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;
import br.com.alura.java.spring.data.jpa.control.employees.orm.UnidadeTrabalho;
import br.com.alura.java.spring.data.jpa.control.employees.repository.CargoRepository;
import br.com.alura.java.spring.data.jpa.control.employees.repository.FuncionarioRepository;
import br.com.alura.java.spring.data.jpa.control.employees.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private final CargoRepository cargoRepository;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public CrudFuncionarioService(CargoRepository cargoRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository,
			FuncionarioRepository funcionarioRepository) {
		this.cargoRepository = cargoRepository;
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de funcionário deseja executar? ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}

	}

	private void salvar(Scanner scanner) {

		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();

		System.out.println("CPF do funcionário: ");
		String cpf = scanner.next();

		System.out.println("Salário do funcionário: ");
		Double salario = scanner.nextDouble();

		System.out.println("Data de contração do funcionário: ");
		String dataContratacao = scanner.next(); // Informar no formato dd/MM/yyyy

		System.out.println("Cargo ID do funcionário: ");
		Integer cargoId = scanner.nextInt();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDatacontratacao(LocalDate.parse(dataContratacao, formatter));
		funcionario.setCargo(cargoRepository.findById(cargoId).get());
		funcionario.setUnidadesTrabalho(definirUnidadesTrabalho(scanner));

		funcionarioRepository.save(funcionario);

		System.out.println("Salvo!");

	}

	private void atualizar(Scanner scanner) {

		System.out.println("Informe o id: ");
		Integer id = scanner.nextInt();

		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();

		System.out.println("CPF do funcionário: ");
		String cpf = scanner.next();

		System.out.println("Salário do funcionário: ");
		Double salario = scanner.nextDouble();

		System.out.println("Data de contração do funcionário: ");
		String dataContratacao = scanner.next(); // Informar no formato dd/MM/yyyy

		System.out.println("Cargo ID do funcionário: ");
		Integer cargoId = scanner.nextInt();

		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDatacontratacao(LocalDate.parse(dataContratacao, formatter));
		funcionario.setCargo(cargoRepository.findById(cargoId).get());

		funcionarioRepository.save(funcionario);

		System.out.println("Atualizado!");

	}

	private void visualizar() {

		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();

		funcionarios.forEach(funcionario -> System.out.println(funcionario));

	}

	private void deletar(Scanner scanner) {

		System.out.println("Informe o id: ");
		Integer id = scanner.nextInt();

		funcionarioRepository.deleteById(id);

		System.out.println("Deletado!");

	}

	private List<UnidadeTrabalho> definirUnidadesTrabalho(Scanner scanner) {

		Boolean isTrue = true;
		List<UnidadeTrabalho> unidadesTrabalho = new ArrayList<UnidadeTrabalho>();

		while (isTrue) {

			System.out.println("Para sair digite 0!");
			System.out.println("Unidade ID do funcionário: ");
			Integer unidadeId = scanner.nextInt();

			if (unidadeId != 0)
				unidadesTrabalho.add(unidadeTrabalhoRepository.findById(unidadeId).get());
			else
				isTrue = false;

		}

		return unidadesTrabalho;

	}

}
