package xyz.rahamatj.dvm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "elections")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "election_seq_gen")
    @SequenceGenerator(
            name = "election_seq_gen",
            sequenceName = "election_id_seq",
            allocationSize = 1
    )
    private Long id;
    private int year;
    private Long candidate_id;
    private Long votes;

    public Election() {
    }

    public Election(int year, Long candidate_id, Long votes) {
        this.year = year;
        this.candidate_id = candidate_id;
        this.votes = votes;
    }

    public Election(Long id, int year, Long candidate_id, Long votes) {
        this.id = id;
        this.year = year;
        this.candidate_id = candidate_id;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }
}
