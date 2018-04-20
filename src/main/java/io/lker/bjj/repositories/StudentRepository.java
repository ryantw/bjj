package io.lker.bjj.repositories;

import io.lker.bjj.models.Student;
import org.springframework.data.repository.CrudRepository;

// Spring data JPA
public interface StudentRepository extends CrudRepository<Student, Long> {

}
