package com.example.gettingstartedspringbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GettingStartedSpringBootJpaApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(GettingStartedSpringBootJpaApplication.class, args);
	}

	private final ProcessorService processorService;

	@Autowired
	public GettingStartedSpringBootJpaApplication(ProcessorService processorService) {
		this.processorService = processorService;
	}

	@Override
	public void run(ApplicationArguments args) {
		Processor processor = new Processor("i7-1165G7", "9.99");

		processorService.insertProcessor(processor);

		processorService.updateProcessor(1, "19.99");

		List<Processor> processors = processorService.selectProcessors();
		for (Processor p : processors) {
			System.out.println(p.getId() + " " + p.getModel() + " " + p.getPrice());
		}

		processorService.deleteProcessor(1);
	}

}
