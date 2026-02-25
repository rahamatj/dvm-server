package xyz.rahamatj.dvm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.rahamatj.dvm.model.Candidate;
import xyz.rahamatj.dvm.model.Election;
import xyz.rahamatj.dvm.model.Symbol;
import xyz.rahamatj.dvm.model.Voter;
import xyz.rahamatj.dvm.repository.CandidateRepository;
import xyz.rahamatj.dvm.repository.ElectionRepository;
import xyz.rahamatj.dvm.repository.SymbolRepository;
import xyz.rahamatj.dvm.repository.VoterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class VoteConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            SymbolRepository symbolRepository,
            CandidateRepository candidateRepository,
            VoterRepository voterRepository,
            ElectionRepository electionRepository
    ) {
        return args -> {

            Symbol[] symbols = {
                    new Symbol("😛"),
                    new Symbol("😝"),
                    new Symbol("😀"),
                    new Symbol("😁"),
                    new Symbol("😅"),
                    new Symbol("🙂"),
                    new Symbol("🤣"),
                    new Symbol("😇"),
                    new Symbol("😍"),
            };

            symbolRepository.saveAll(List.of(symbols));

            List<Candidate> candidates = new ArrayList<>();

            candidates.add(new Candidate("A", symbols[0], 250L));
            candidates.add(new Candidate("B", symbols[1], 250L));
            candidates.add(new Candidate("C", symbols[2], 250L));
            candidates.add(new Candidate("D", symbols[3], 250L));
            candidates.add(new Candidate("E", symbols[4], 250L));
            candidates.add(new Candidate("F", symbols[5], 250L));
            candidates.add(new Candidate("G", symbols[6], 250L));
            candidates.add(new Candidate("H", symbols[7], 250L));
            candidates.add(new Candidate("I", symbols[8], 250L));

            candidateRepository.saveAll(candidates);

            Random random = new Random();
            Candidate c1 = candidates.get(random.nextInt(candidates.size()));
            Candidate c2 = candidates.get(random.nextInt(candidates.size()));

            Election election1 = new Election(2026, c1.getId(), 250L);
            Election election2 = new Election(2021, c2.getId(), 200L);

            electionRepository.saveAll(List.of(election1, election2));

            Voter mariam = new Voter("Mariam", "1234", symbols[0]);
            Voter alex = new Voter("Alex", "4321", symbols[1]);

            voterRepository.saveAll(List.of(mariam, alex));
        };
    }
}
