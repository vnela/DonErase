package ohjelmistoprojekti.kyselysovellus.web;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.kyselysovellus.domain.Answer;

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
	

	@PostMapping(
		value="/api/submitAnswer",
		consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Answer submitAnswer(@RequestBody AnswerValuetoQuestion requestAnswer) {
		
		String answerInput = requestAnswer.getAnswerInput();
		Long qid = requestAnswer.getQid();
		Question question = qRepository.findByQid(qid).get(0);		
		Answer answer = new Answer(answerInput, question);
		
		aRepository.save(answer);
		return answer;
	}
	
	@PostMapping(
			value="/api/submitAnswers",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
							
		public List<Answer> createAnswerList(@RequestBody List<AnswerValuetoQuestion> requestAnswers) {
		
		List<Answer> answers = new ArrayList<Answer>();
					
			for (int i = 0; i < requestAnswers.size(); i++) {	
				String answerValue = requestAnswers.get(i).getAnswerInput();
				Long qid = requestAnswers.get(i).getQid();
				Question question = qRepository.findByQid(qid).get(0);
				Answer answer = new Answer(answerValue, question);
				aRepository.save(answer);	
				answers.add(answer);
			}
			return answers;
		}
	

	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> getActualAnswersRest(){
		return (List<Answer>) aRepository.findAll();
	}
	

	@RequestMapping(value="/answer/{aid}", method=RequestMethod.GET)
	public @ResponseBody Optional<Answer> findAnswerIdRest(@PathVariable("aid") Long id) {
		return aRepository.findByAid(id);
	}


}
