package tradingz.firstproject.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import tradingz.firstproject.models.Stock;
import tradingz.firstproject.repositories.StockRespository;

@Controller
public class StockController {
    private final StockRespository stockRespository;
    public StockController(final StockRespository stockRespository){
        this.stockRespository = stockRespository;
    }

    @MutationMapping
    public Stock newStock(
            @Argument String symbol,
            @Argument String name,
            @Argument String currency
    ){
        Stock stock = new Stock(symbol, name, currency);
        stockRespository.save(stock);
        return stock;
    }

}
