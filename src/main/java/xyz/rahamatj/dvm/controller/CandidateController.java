package xyz.rahamatj.dvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.rahamatj.dvm.model.Candidate;
import xyz.rahamatj.dvm.repository.CandidateRepository;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping("/")
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @GetMapping("/{id}")
    public Candidate voteCandidate(@PathVariable Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setVotes(candidate.getVotes() + 1);

        candidateRepository.save(candidate);

        return candidate;
    }
}
