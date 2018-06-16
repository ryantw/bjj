package io.lker.bjj.services;

import io.lker.bjj.models.Instructor;
import io.lker.bjj.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Set<Instructor> getInstructors() {
        Set<Instructor> instructors = new HashSet<>();
        instructorRepository.findAll().iterator().forEachRemaining(instructors::add);

        return instructors;
    }

    @Override
    public Instructor findById(Long l) {
        Optional<Instructor> instructor = instructorRepository.findById(l);
        if(!instructor.isPresent()){
            throw new RuntimeException("Missing Instructor ID.");
        }
        return instructor.get();
    }
}
