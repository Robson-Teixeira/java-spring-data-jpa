package br.com.alura.java.spring.data.jpa.control.employees.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome) {

		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");

	}

	public static Specification<Funcionario> cpf(String cpf) {

		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("cpf"), cpf);

	}

	public static Specification<Funcionario> salario(Double salario) {

		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.greaterThan(root.get("salario"), salario);

	}

	public static Specification<Funcionario> datacontratacao(LocalDate datacontratacao) {

		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.greaterThan(root.get("datacontratacao"), datacontratacao);

	}

}
