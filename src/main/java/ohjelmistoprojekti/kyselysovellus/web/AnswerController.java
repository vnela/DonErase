package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
	
	//
    @GetMapping("/answers")
    List<Answer> all() {
    	System.out.println("tuleeko kaikki vastaukset???");
    	//System.out.println(aRepository.findAll()); 	
		return (List<Answer>) aRepository.findAll();
	}
    
  
    @GetMapping("/answers/{id}")
    Optional<Answer> oneAnswer(@PathVariable Long id) {	
    	return aRepository.findById(id);
    } 
    
    
    @GetMapping("/questions/{id}/answers")
    QuestionRepository oneAnswerbyQ(@PathVariable Long id) {
    	System.out.println("getti, toimiiko?");
    	return (QuestionRepository) qRepository.findById(id).get();
    } 
    
    /*
    //testausta1: etsi kaikki vastaukset kysymyksen id:n perusteella
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
   /@GetMapping("/questions/{id}/answers")
    List<Answer> one(@PathVariable Long id) {	
    	return aRepository.findByQuestionId(id);
    }*/
    
    /*
  //testausta2: etsi kaikki vastaukset kysymyksen id:n perusteella
    @GetMapping("/questions/{qid}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable (value = "qid") Long qid) {
        return aRepository.findByQid(qid);
    }*/
    
    //testausta3: lisätään uusi vastaus kysymykseen
    @PostMapping("/questions/{qid}")
    public Answer createAnswer(@PathVariable (value = "qid") Long qid, @RequestBody Answer newAnswer) {
    	System.out.println("toimiiko?");
        return qRepository.findById(qid).map(question -> {
        	newAnswer.setQuestion(question);
            return aRepository.save(newAnswer);
        }).orElseThrow(() -> new ResourceNotFoundException("qid " + qid + " not found"));
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