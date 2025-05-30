package com.michalsniezko.jpa_course;

import com.github.javafaker.Faker;
import com.michalsniezko.jpa_course.models.Author;
import com.michalsniezko.jpa_course.repositories.AuthorRepository;
import com.michalsniezko.jpa_course.repositories.VideoRepository;
import com.michalsniezko.jpa_course.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (
            AuthorRepository authorRepository,
            VideoRepository videoRepository
    ) {
		return args -> {
			Faker faker = new Faker();
			for (int i = 0; i < 50; i++) {
				Author author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19,50))
						.email(faker.internet().emailAddress())
						.build();
//				authorRepository.save(author);
			}
//			authorRepository.updateAuthor(24, 1);
			Specification<Author> authorSpecification =
					AuthorSpecification.hasAge(24)
					.and(AuthorSpecification.firstNameLike("Ade"));

			authorRepository.findAll(authorSpecification).forEach(System.out::println);
		};
	}
}
