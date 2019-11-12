package ohjelmistoprojekti.kyselysovellus.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	// RESTful service to get all questions
	/*
	 * @RequestMapping(value="/questions", method = RequestMethod.GET)
	 * public @ResponseBody List<Question> questionListRest() { return
	 * (List<Question>) qRepository.findAll();
	 * 
	 * }
	 */

		@GetMapping("/questions")
		List<Question> all() {
			return (List<Question>) qRepository.findAll();
		}

	// RESTful service to get question by id
	/*
	 * @RequestMapping(value="/question/{id}", method = RequestMethod.GET)
	 * public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id")
	 * Long questionId) { return qRepository.findById(questionId); }
	 */

	@GetMapping("/question/{id}")
	Optional<Question> one(@PathVariable Long id) {
		return qRepository.findById(id);
		// .orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	// RESTful service to post question/answer
	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public @ResponseBody List<Question> questionanswerListRest() {
		return (List<Question>) qRepository.findAll();
	}

	/*
	@PostMapping("/questions")
	Questions newQuestion(@RequestBody Question newQuestion) {
		return repository.save(newEmployee);
	}*/

}