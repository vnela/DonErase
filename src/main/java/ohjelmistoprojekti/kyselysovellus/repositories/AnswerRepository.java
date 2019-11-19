package ohjelmistoprojekti.kyselysovellus.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti.kyselysovellus.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	 List<Answer> findByInput(String input);

}