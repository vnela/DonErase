package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.domain.QuestionRepository;

@Controller
public class KyselyController {
	@Autowired
	private QuestionRepository qRepository;
	
	// RESTful service to get all questions
    @RequestMapping(value="/questions", method = RequestMethod.GET)
    public @ResponseBody List<Question> questionListRest() {	
        return (List<Question>) qRepository.findAll();

    }
    
 // RESTful service to get question by id
    @RequestMapping(value="/question/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long questionId) {	
    	return qRepository.findById(questionId);
    } 
}