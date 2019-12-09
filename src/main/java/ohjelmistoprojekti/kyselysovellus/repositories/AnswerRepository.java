package ohjelmistoprojekti.kyselysovellus.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti.kyselysovellus.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	Optional<Answer> findByAid(Long aid);


}