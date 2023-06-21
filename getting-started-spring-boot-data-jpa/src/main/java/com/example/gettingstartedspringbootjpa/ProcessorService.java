package com.example.gettingstartedspringbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProcessorService {

    private final ProcessorRepository processorRepository;

    @Autowired
    public ProcessorService(ProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }

    public void insertProcessor(Processor processor) {
        processorRepository.save(processor);
    }

    public List<Processor> selectProcessors() {
        List<Processor> processors = new ArrayList<>();
        processorRepository.findAll().forEach(processors::add);
        return processors;
    }

    public Optional<Processor> selectProcessor(int id) {
        return processorRepository.findById(id);
    }

    public void updateProcessor(int id, String price) {
        Optional<Processor> processorToUpdate = selectProcessor(id);
        processorToUpdate.ifPresent(processor -> processor.setPrice(price));
    }

    public void deleteProcessor(int id) {
        Optional<Processor> processorToDelete = selectProcessor(id);
        processorToDelete.ifPresent(processorRepository::delete);
    }

}
