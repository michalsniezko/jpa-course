package com.michalsniezko.jpa_course.repositories;

import com.michalsniezko.jpa_course.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    @Modifying
    @Query("update Author a set a.age = :age where a.id = :id")
    @Transactional
    void updateAuthor(int age, int id);

    List<Author> findByNamedQuery(@Param("age") int age);
}
