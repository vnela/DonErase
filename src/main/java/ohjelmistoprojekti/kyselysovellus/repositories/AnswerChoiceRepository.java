package ohjelmistoprojekti.kyselysovellus.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.Question;

public interface AnswerChoiceRepository extends CrudRepository<AnswerChoice, Long>{
	List<AnswerChoice> findByValue(String value);
	List<AnswerChoice> findByQuestion(Question question);
}
