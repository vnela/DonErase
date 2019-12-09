package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

@Controller
public class ThymeleafController {

	@Autowired
	QuestionRepository qRepository;
	
	
		
		@RequestMapping(value = "/questionlist", method = RequestMethod.GET)
		public String getQuestions(Model title) {
				List<Question> questions =  (List<Question>) qRepository.findAll();
				title.addAttribute("questions", questions);
				return "questionlist"; 
		}
		

		@RequestMapping(value = "/newquestion", method = RequestMethod.GET)
		public String getNewQuestionForm(Model title) {
				title.addAttribute("question", new Question()); 
				return "addquestion";
		}
				

		@RequestMapping(value = "/newquestion", method = RequestMethod.POST)
		public String saveQuestion(@ModelAttribute Question question) {

				qRepository.save(question);
				return "redirect:/questionlist";
		}
				

		@RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.GET)
		public String deleteQuestions(@PathVariable("id") Long Qid) {
				qRepository.deleteById(Qid);
				return "redirect:../questionlist";
		}
				

		@RequestMapping(value ="/editquestion/{id}", method = RequestMethod.GET)
		public String editQuestion(@PathVariable("id") Long Qid, Model title) {
				title.addAttribute("question", qRepository.findById(Qid));
				return "editquestion";
		}
				
		@RequestMapping(value = "/editquestion", method = RequestMethod.POST)
		public String updateQuestion(@ModelAttribute Question question) {

					qRepository.save(question);
					return "redirect:/questionlist";
		}	

	
}
