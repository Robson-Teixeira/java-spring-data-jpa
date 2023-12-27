package br.com.alura.java.spring.data.jpa.control.employees.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.java.spring.data.jpa.control.employees.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	List<Funcionario> findByNome(String nome);

	// List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate data);
	// Ou
	// Especifica que não se trata de uma derived query
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.datacontratacao = :datacontratacao")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate datacontratacao);

	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	// Ou
	List<Funcionario> findByCargoDescricao(String descricao);

	@Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
	// Ou
	List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
}
