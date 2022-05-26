package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentsJpaDaoImpl implements DaoService<Student> {

    @PersistenceContext
    private final EntityManager em;

    @Override
    @Transactional
    public Student save(Student student) {
        if(student.getId() == null){
            em.persist(student);
            return student;
        } else {
            return em.merge(student);
        }
    }

    @Override
    public List<Student> findAll() {
        Query query = em.createQuery("select s from Student s");
        return query.getResultList();
    }
}
