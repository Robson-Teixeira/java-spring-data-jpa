package br.com.alura.java.spring.data.jpa.control.employees.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.java.spring.data.jpa.control.employees.orm.UnidadeTrabalho;
import br.com.alura.java.spring.data.jpa.control.employees.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private Boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de unidade de trabalho deseja executar? ");
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

		System.out.println("Descrição da unidade de trabalho: ");
		String descricao = scanner.next();

		System.out.println("Endereco da unidade de trabalho: ");
		String endereco = scanner.next();

		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);

		unidadeTrabalhoRepository.save(unidadeTrabalho);

		System.out.println("Salvo!");

	}

	private void atualizar(Scanner scanner) {

		System.out.println("Informe o id: ");
		Integer id = scanner.nextInt();

		System.out.println("Descrição da unidade de trabalho: ");
		String descricao = scanner.next();

		System.out.println("Endereco da unidade de trabalho: ");
		String endereco = scanner.next();

		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);

		unidadeTrabalhoRepository.save(unidadeTrabalho);

		System.out.println("Atualizado!");

	}

	private void visualizar() {

		Iterable<UnidadeTrabalho> unidadesTrabalho = unidadeTrabalhoRepository.findAll();

		unidadesTrabalho.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));

	}

	private void deletar(Scanner scanner) {

		System.out.println("Informe o id: ");
		Integer id = scanner.nextInt();

		unidadeTrabalhoRepository.deleteById(id);

		System.out.println("Deletado!");

	}

}
