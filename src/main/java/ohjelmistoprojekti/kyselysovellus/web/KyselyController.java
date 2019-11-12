package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.domain.QuestionRepository;

@RestController
public class KyselyController {
	@Autowired
	private QuestionRepository qRepository;
	
	KyselyController(QuestionRepository repository){
		this.qRepository = repository;
		
	}
	
	// RESTful service to get all questions
    @GetMapping("/questions")
    List<Question> all() {
		return (List<Question>) qRepository.findAll();
	}
    
    // RESTful service to get question by id
    @GetMapping("/questions/{id}")
    Optional<Question> one(@PathVariable Long id) {	
    	return qRepository.findById(id);
    } 
    
    // RESTful service to post question/answer
    @PostMapping("/questions")
    List<Question> newQuestion(@RequestBody Question newQuestion) {	
        return (List<Question>) qRepository.save(newQuestion);
    
    }
    
    // RESTful service to update question/answer
    @PutMapping("/questions/{id}")
    Question updateQuestion(@RequestBody Question newQuestion, @PathVariable Long id){
    	
    	return qRepository.findById(id)
    			.map(question ->{
    				question.setTitle(newQuestion.getTitle());
    				question.setType(newQuestion.getType());
    				question.setAnswer(newQuestion.getAnswer());
    				return qRepository.save(question);
    				
    			})
    			.orElseGet(() -> {
    				newQuestion.setQid(id);
    				return qRepository.save(newQuestion);
    			});
  	
    }
    
    // RESTful service to delete question/answer
    @DeleteMapping("/questions/{id}")
    	void deleteQuestion(@PathVariable Long id) {
    		qRepository.deleteById(id);
    	}
    
    
}