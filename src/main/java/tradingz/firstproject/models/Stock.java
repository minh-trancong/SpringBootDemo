package tradingz.firstproject.models;

import javax.persistence.*;

@Entity
@Table(name="stocks")
public class Stock {
    public Stock() {
    }
    public Stock(String symbol, String name, String currency) {
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="symbol")
    private String symbol;

    @Column(name="name")
    private String name;

    @Column(name="currency")
    private String currency;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
