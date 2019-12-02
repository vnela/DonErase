package ohjelmistoprojekti.kyselysovellus.web;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
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
import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoiceLink;
import ohjelmistoprojekti.kyselysovellus.domain.AnswerValuetoQuestion;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

@RestController
public class AnswerController {
	@Autowired
	private AnswerRepository aRepository;
		
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
    
    /*
    @GetMapping("/questions/{id}/answers")
    QuestionRepository oneAnswerbyQ(@PathVariable Long id) {
    	
    	return (QuestionRepository) qRepository.findById(id).get();
    } */
    
    @GetMapping("/questions/{id}/answers")
    Optional<Question> one(@PathVariable Long id) {	
    	return qRepository.findById(id);
    } 
    
    
    // RESTful service to post answer
    @SuppressWarnings("unchecked")
	@PostMapping("/answers")
    List<Answer> newAnswer(@RequestBody Answer newAnswer) {	
        return (List<Answer>) aRepository.save(newAnswer);
    }
    
 
  
    @PostMapping("/api/sendAnswer")
    	
    	public Answer sendAnswer(@RequestBody AnswerValuetoQuestion requestAnswer) {
    		
    		String answerValue = requestAnswer.getAnswerValue();
    		
    		Long qid = requestAnswer.getqId();
    		
    		Question question = qRepository.findByQid(qid).get(0);
    				
    		Answer answer = new Answer(answerValue, question);
    		
    		aRepository.save(answer);
    		
    		return answer;
    	}
    	
    	@PostMapping("/api/Answers")
    		
    							
    		public List<Answer> createAnswerList(@RequestBody List<AnswerValuetoQuestion> requestAnswers) {
    		
    		List<Answer> answers = new ArrayList<Answer>();
    					
    			for (int i = 0; i < requestAnswers.size(); i++) {
    				
    				String answerValue = requestAnswers.get(i).getAnswerValue();
    				
    				Long qid = requestAnswers.get(i).getqId();
    				
    				Question question = qRepository.findByQid(qid).get(0);
    						
    				Answer answer = new Answer(answerValue, question);
    				
    				aRepository.save(answer);
    				
    				answers.add(answer);
    			}
    			return answers;
    		}
    	
    
  
    
    // RESTful service to delete answer
    @DeleteMapping("/answers/{id}")
    	void deleteAnswer(@PathVariable Long id) {
    		aRepository.deleteById(id);
    	}
    
    
}