package ohjelmistoprojekti.kyselysovellus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.kyselysovellus.domain.Answer;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

@SpringBootApplication
public class KyselysovellusApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselysovellusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselysovellusApplication.class, args);
	}

	@Bean
	public CommandLineRunner questionDemo(QuestionRepository qRepository, AnswerRepository aRepository) {
		return (args) -> {
			log.info("Save some questions");

			qRepository.save(new Question("1. Minkä vuoden opiskelija olet?", ""));
			qRepository.save(new Question("2. Mihin profiiliin olet suuntautumassa/suuntautunut?", ""));
			qRepository.save(new Question("3. Miten mielestäsi HOPS:iin perehdytettiin opintojen alussa?", ""));
			qRepository.save(new Question("4. Minkälaisia ongelmia olet kohdannut opintojen edetessä HOPS:iin liittyen?", ""));
			qRepository.save(new Question("5. Minkälaisia ominaisuuksia HOPS:in luomiseen voitaisiin lisätä?", ""));
			log.info("fetch all questions");
			for (Question question : qRepository.findAll()) {
				log.info(question.toString());
			}
			
			/*
			aRepository.save(new Answer("yksi vastaus (CommandLineRunner)", (long) 1));
			aRepository.save(new Answer("toinen vastaus (CommandLineRunner)", (long) 1));
			aRepository.save(new Answer("tämä vastaus ei kai kuulu mihinkään kysymykseen (CommandLineRunner)"));
			*/
		};
	}
}
