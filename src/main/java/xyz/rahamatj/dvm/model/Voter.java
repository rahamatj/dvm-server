package xyz.rahamatj.dvm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voters")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voter_seq_gen")
    @SequenceGenerator(
            name = "voter_seq_gen",
            sequenceName = "voters_id_seq",
            allocationSize = 1
    )
    private Long id;

    @OneToOne
    private Symbol symbol;
    private String name;
    private String nid;

    private boolean hasVoted;

    public Voter() {
    }

    public Voter(String name, String nid) {
        this.name = name;
        this.nid = nid;
    }

    public Voter(String name, String nid, Symbol symbol) {
        this.name = name;
        this.nid = nid;
        this.symbol = symbol;
    }

    public Voter(Long id, String name, String nid, Symbol symbol, boolean hasVoted) {
        this.id = id;
        this.name = name;
        this.nid = nid;
        this.symbol = symbol;
        this.hasVoted = hasVoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}