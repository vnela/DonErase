package ohjelmistoprojekti.kyselysovellus.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ohjelmistoprojekti.kyselysovellus.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	 List<Question> findByTitle(String title);
	 List<Question> findByQid(long qid);
	 List<Question> findAllByType(String type);
}
