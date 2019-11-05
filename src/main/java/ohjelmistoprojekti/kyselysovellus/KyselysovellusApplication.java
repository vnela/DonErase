package ohjelmistoprojekti.kyselysovellus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.domain.QuestionRepository;

@SpringBootApplication
public class KyselysovellusApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselysovellusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselysovellusApplication.class, args);
	}

	@Bean
	public CommandLineRunner questionDemo(QuestionRepository qRepository) {
		return (args) -> {
			log.info("Save some questions");

			qRepository.save(new Question("Minkä vuoden opiskelija olet?", ""));
			qRepository.save(new Question("Mihin profiiliin olet suuntautumassa/suuntautunut?", ""));
			qRepository.save(new Question("Miten mielestäsi HOPS:iin perehdytettiin opintojen alussa?", ""));
			qRepository.save(new Question("Minkälaisia ongelmia olet kohdannut opintojen edetessä HOPS:iin liittyen?", ""));
			qRepository.save(new Question("Minkälaisia ominaisuuksia HOPS:in luomiseen voitaisiin lisätä?", ""));
			log.info("fetch all questions");
			for (Question question : qRepository.findAll()) {
				log.info(question.toString());
			}

		};
	}
}
