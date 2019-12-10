package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerChoiceRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

public class QuestionController {
	
	
	@Autowired
	private QuestionRepository qRepository;
	
	@Autowired 
	private AnswerChoiceRepository acRepository;
	

	@CrossOrigin(origins = "https://localhost:8080")
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestion(){
		return (List<Question>) qRepository.findAll();
	}
	
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long id) {
		return qRepository.findById(id);
	}
	

	@RequestMapping(value="/questionType/{type}", method=RequestMethod.GET)
	public @ResponseBody List<Question> questions (@PathVariable("type") String type) {					
		return qRepository.findAllByType(type);
	}
	
	
	@RequestMapping(value="/answerChoices", method = RequestMethod.GET)
	public @ResponseBody List<AnswerChoice> getAnswerRest(){
		return (List<AnswerChoice>) acRepository.findAll();
	}
	

	@RequestMapping(value="/answerChoice/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<AnswerChoice> findAnswerRest(@PathVariable("acid") Long id) {
		return acRepository.findById(id);
	}
	

	@RequestMapping(value="/createQuestion", method=RequestMethod.GET)
	public String createQuestion(Model model) {
		model.addAttribute("question", new Question());
	    model.addAttribute("option", new AnswerChoice());
		return "createquestion";
	}
	
	
}
