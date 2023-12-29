package br.com.alura.java.spring.data.jpa.control.employees.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome) {

		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");

	}

}
