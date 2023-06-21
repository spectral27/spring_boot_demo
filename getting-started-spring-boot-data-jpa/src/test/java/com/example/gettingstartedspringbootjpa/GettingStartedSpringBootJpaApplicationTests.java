package com.example.gettingstartedspringbootjpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
@SuppressWarnings("unused")
class GettingStartedSpringBootJpaApplicationTests {

	@Autowired
	private ProcessorService processorService;

	@MockBean
	private ProcessorRepository processorRepository;

	@Test
	void selectTest() {
		Mockito.when(processorRepository.findAll()).thenReturn(() -> List.of(new Processor()).iterator());
		List<Processor> processors = processorService.selectProcessors();
		Assertions.assertTrue(processors.size() > 0);
	}

}
