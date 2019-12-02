package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerChoiceRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

public class QuestionaireController {
	
	@Autowired
	public QuestionRepository qRepository;
	
	@Autowired 
	public AnswerChoiceRepository acRepository;

	//RESTful service to get all questions
	@CrossOrigin(origins = "https://localhost:8080")
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestionRest(){
		return (List<Question>) qRepository.findAll();
	}
	
	//RESTful service to get one questions
	@RequestMapping(value="/question/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long id) {
		return qRepository.findById(id);
	}
	
	// one question by type 
	@RequestMapping(value="/questionType/{type}", method=RequestMethod.GET)
	public @ResponseBody List<Question> questions (@PathVariable("type") String type) {					
		return qRepository.findAllByType(type);
	}
	
	//RESTful service to get all answer options
	@RequestMapping(value="/answerChoices", method = RequestMethod.GET)
	public @ResponseBody List<AnswerChoice> getAnswerRest(){
		return (List<AnswerChoice>) acRepository.findAll();
	}
	
	//RESTful service to get one answer options by id
	@RequestMapping(value="/answerChoice/{answerid}", method=RequestMethod.GET)
	public @ResponseBody Optional<AnswerChoice> findAnswerRest(@PathVariable("answerid") Long id) {
		return acRepository.findById(id);
	}
}
