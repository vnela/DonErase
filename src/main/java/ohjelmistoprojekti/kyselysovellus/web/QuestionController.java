package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoiceLink;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerChoiceRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

public class QuestionController {
	
	
	@Autowired
	private QuestionRepository qRepository;
	
	@Autowired 
	private AnswerChoiceRepository acRepository;
	

	
	//RESTful service to get all questions
	@CrossOrigin(origins = "https://localhost:8080")
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestion(){
		System.out.println("toimiiko?");
		return (List<Question>) qRepository.findAll();
	}
	
	//RESTful service to get one questions
	@RequestMapping(value="/questions/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long id) {
		System.out.println("toimiiko?HALOOOOOAASKDKASDKAS");
		return qRepository.findById(id);
	}
	
	// RESTful service to get one question by type 
	@RequestMapping(value="/questionType/{type}", method=RequestMethod.GET)
	public @ResponseBody List<Question> questions (@PathVariable("type") String type) {					
		return qRepository.findAllByType(type);
	}
	
	//RESTful service to get all answer choices
	@RequestMapping(value="/answerChoices", method = RequestMethod.GET)
	public @ResponseBody List<AnswerChoice> getAnswerRest(){
		return (List<AnswerChoice>) acRepository.findAll();
	}
	
	//RESTful service to get one answer choices by id
	@RequestMapping(value="/answerChoice/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<AnswerChoice> findAnswerRest(@PathVariable("acid") Long id) {
		return acRepository.findById(id);
	}
	
	//RESTful service to create question
	@RequestMapping(value="/createQuestion", method=RequestMethod.GET)
	public String createQuestion(Model model) {
		model.addAttribute("question", new Question());
	    model.addAttribute("option", new AnswerChoice());
		return "createquestion";
	}
	
	
	
	//Thymeleaf methods
	
	
	//Save method for new question
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveQuestion(@ModelAttribute Question question) {
		qRepository.save(question);
		return "redirect:/questionlist";
		
	}
	
	//List of questions
	@RequestMapping(value="/questionlist")
	public String getQuestions(Model model) {
		List<Question> questions = (List<Question>) qRepository.findAll();
		model.addAttribute("questions", questions);
		return "questionlist";
	}
	
	//Add answerOptions to newly selected
	@RequestMapping(value="edit/{id}")
	public String editQuestion(@PathVariable("id") Long id, Model model) {
		model.addAttribute("question", qRepository.findById(id));
		return "editquestion";
	}

	
	//Save method for answerOptions 
	@RequestMapping(value="/saveoption", method=RequestMethod.POST)
	public String saveChoices(AnswerChoiceLink answerChoiceLink) {
		String value = answerChoiceLink.getValue();
		Long qid = answerChoiceLink.getqId();
		
		Question question = qRepository.findByQid(qid).get(0);
		AnswerChoice answerChoice = new AnswerChoice(value, question);
		acRepository.save(answerChoice);
		return "redirect:/questionlist";
	}
	
	//Delete question
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id") Long id) {
		qRepository.deleteById(id);
		return "redirect:../questionlist";
	}
	
	//Add answer choices
	@RequestMapping(value="/add/{id}", method=RequestMethod.GET)
	public String addOptions(@PathVariable("id") Long qid, Model model) {
		model.addAttribute("answerChoiceLink", new AnswerChoiceLink(qid));
		return "createoptions";
	}
	
}
