package xyz.rahamatj.dvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rahamatj.dvm.model.Voter;
import xyz.rahamatj.dvm.repository.VoterRepository;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    @Autowired
    private final VoterRepository voterRepository;

    public VoterController(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @GetMapping("/")
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @GetMapping("/{nid}")
    public ResponseEntity<String> findVoterByNid(@PathVariable String nid) {
        Voter voter = voterRepository.findByNid(nid);
        boolean nidExists = voterRepository.existsByNid(nid);

        if (nidExists) {
            return ResponseEntity.ok("Nid exists!");
        }

        if (voter.getHasVoted()) {
            return ResponseEntity.ok("You have already voted!");
        }

        return ResponseEntity.ok("Vote done!");
    }
}
