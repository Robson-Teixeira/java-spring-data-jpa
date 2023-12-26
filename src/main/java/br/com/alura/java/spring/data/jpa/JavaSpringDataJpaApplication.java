package br.com.alura.java.spring.data.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.java.spring.data.jpa.orm.Cargo;
import br.com.alura.java.spring.data.jpa.repository.CargoRepository;

@SpringBootApplication
public class JavaSpringDataJpaApplication implements CommandLineRunner {

	private final CargoRepository cargoRepository;

	public JavaSpringDataJpaApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringDataJpaApplication.class, args);
	}

	@Override
	// Método da CommandLineRunner executado após o método main
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor de Software");
		cargoRepository.save(cargo);
	}

}
