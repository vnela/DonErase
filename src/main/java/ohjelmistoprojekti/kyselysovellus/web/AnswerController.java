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

import ohjelmistoprojekti.kyselysovellus.domain.Answer;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

@RestController
public class AnswerController {
	@Autowired
	private AnswerRepository aRepository;
	
	AnswerController(AnswerRepository arepository){
		this.aRepository = arepository;
	}
	
	@Autowired
	private QuestionRepository qRepository;
	
	// RESTful service to get all questions
    @GetMapping("/answers")
    List<Answer> all() {
		return (List<Answer>) aRepository.findAll();
	}
    
    // RESTful service to get answer by id
    @GetMapping("/answers/{id}")
    Optional<Answer> oneAnswer(@PathVariable Long id) {	
    	return aRepository.findById(id);
    } 
    
    // RESTful service to get answer by id
    @GetMapping("/questions/{id}/answers")
    QuestionRepository oneAnswerbyQ(@PathVariable Long id) {
    	
    	return (QuestionRepository) qRepository.findById(id).get();
    } 
    
    
    // RESTful service to post answer
    @SuppressWarnings("unchecked")
	@PostMapping("/answers")
    List<Answer> newAnswer(@RequestBody Answer newAnswer) {	
        return (List<Answer>) aRepository.save(newAnswer);
    
    }
   
    
    // RESTful service to update answer
    @PutMapping("/answers/{id}")
    Answer updateAnswer(@RequestBody Answer newAnswer, @PathVariable Long id){
    	
    	return aRepository.findById(id)
    			.map(answer ->{
    				answer.setInput(newAnswer.getInput());
    				return aRepository.save(answer);
    				
    			})
    			.orElseGet(() -> {
    				newAnswer.setAid(id);
    				return aRepository.save(newAnswer);
    			});
  	
    }
    
    // RESTful service to delete answer
    @DeleteMapping("/answers/{id}")
    	void deleteAnswer(@PathVariable Long id) {
    		aRepository.deleteById(id);
    	}
    
    
}