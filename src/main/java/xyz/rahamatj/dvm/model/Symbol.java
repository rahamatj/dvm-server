package xyz.rahamatj.dvm.model;
import jakarta.persistence.*;

@Entity
@Table(name = "symbols")
public class Symbol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "symbol_seq_gen")
    @SequenceGenerator(
            name = "symbol_seq_gen",
            sequenceName = "symbol_id_seq",
            allocationSize = 1
    )
    Long id;
    String emoji;

    public Symbol() {
    }

    public Symbol(Long id, String emoji) {
        this.id = id;
        this.emoji = emoji;
    }

    public Symbol(String emoji) {
        this.emoji = emoji;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
