package br.com.alura.java.spring.data.jpa.control.employees.orm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	private LocalDate datacontratacao;
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades", joinColumns = {
			@JoinColumn(name = "fk_funcionario") }, inverseJoinColumns = { @JoinColumn(name = "fk_unidade") })
	private List<UnidadeTrabalho> unidadesTrabalho = new ArrayList<UnidadeTrabalho>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getDatacontratacao() {
		return datacontratacao;
	}

	public void setDatacontratacao(LocalDate datacontratacao) {
		this.datacontratacao = datacontratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<UnidadeTrabalho> getUnidadesTrabalho() {
		return unidadesTrabalho;
	}

	public void setUnidadesTrabalho(List<UnidadeTrabalho> unidadesTrabalho) {
		this.unidadesTrabalho = unidadesTrabalho;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario
				+ ", datacontratacao=" + datacontratacao + ", cargo=" + cargo.getDescricao() + "]";
	}

}
