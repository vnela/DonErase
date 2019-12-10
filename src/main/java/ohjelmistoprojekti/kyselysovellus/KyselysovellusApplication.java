package ohjelmistoprojekti.kyselysovellus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import ohjelmistoprojekti.kyselysovellus.domain.AnswerChoice;
import ohjelmistoprojekti.kyselysovellus.domain.Question;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerChoiceRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.AnswerRepository;
import ohjelmistoprojekti.kyselysovellus.repositories.QuestionRepository;

@SpringBootApplication
public class KyselysovellusApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselysovellusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselysovellusApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings (CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	
	@Bean
	public CommandLineRunner questionDemo(QuestionRepository qRepository, AnswerRepository aRepository, AnswerChoiceRepository acRepository) {
		return (args) -> {
			log.info("Save some questions");

			//Questions
	
			qRepository.save(new Question("Minkä vuoden opiskelija olet?", "radio"));
			qRepository.save(new Question("Mihin profiiliin olet suuntautumassa/suuntautunut?", "drop-down"));
			qRepository.save(new Question("Miten mielestäsi HOPS:iin perehdytettiin opintojen alussa?", "avoin"));
			qRepository.save(new Question("Minkälaisia ongelmia olet kohdannut opintojen edetessä HOPS:iin liittyen?", "avoin"));
			qRepository.save(new Question("Minkälaisia ominaisuuksia HOPS:in luomiseen voitaisiin lisätä?", "avoin"));
			
			//Answer choices
			//1
			acRepository.save(new AnswerChoice("1.vuoden",qRepository.findByQid(1).get(0)));
			acRepository.save(new AnswerChoice("2.vuoden",qRepository.findByQid(1).get(0)));
			acRepository.save(new AnswerChoice("3.vuoden",qRepository.findByQid(1).get(0)));
			acRepository.save(new AnswerChoice("4.vuoden",qRepository.findByQid(1).get(0)));
			acRepository.save(new AnswerChoice("5.vuoden",qRepository.findByQid(1).get(0)));
			
			//2
			acRepository.save(new AnswerChoice("Ohjelmistotuotanto",qRepository.findByQid(2).get(0)));
			acRepository.save(new AnswerChoice("Digitaaliset palvelut",qRepository.findByQid(2).get(0)));
			acRepository.save(new AnswerChoice("ICT-infrastruktuuri",qRepository.findByQid(2).get(0)));
			acRepository.save(new AnswerChoice("ICT ja liiketoiminta",qRepository.findByQid(2).get(0)));
			
		
			/*//3
			acRepository.save(new AnswerChoice("",qRepository.findByQid(3).get(0)));
			//4
			acRepository.save(new AnswerChoice("",qRepository.findByQid(4).get(0)));
			//5
			acRepository.save(new AnswerChoice("",qRepository.findByQid(5).get(0)));*/
			

		};
	}
}
		
