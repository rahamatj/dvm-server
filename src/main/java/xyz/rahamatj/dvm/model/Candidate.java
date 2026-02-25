package xyz.rahamatj.dvm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq_gen")
    @SequenceGenerator(
            name = "candidate_seq_gen",
            sequenceName = "candidate_id_seq",
            allocationSize = 1
    )
    Long id;
    String name;

    @OneToOne
    Symbol symbol;

    Long votes;

    public Candidate() {
    }

    public Candidate(String name, Symbol symbol, Long votes) {
        this.name = name;
        this.symbol = symbol;
        this.votes = votes;
    }

    public Candidate(Long id, String name, Symbol symbol, Long votes) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }
}