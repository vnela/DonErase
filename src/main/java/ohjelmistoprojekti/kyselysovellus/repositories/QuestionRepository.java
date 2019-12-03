package ohjelmistoprojekti.kyselysovellus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti.kyselysovellus.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	 List<Question> findByTitle(String title);
	 Optional<Question> findById(Long qid);
	 Optional<Question> findByQid(Long qid);

}
