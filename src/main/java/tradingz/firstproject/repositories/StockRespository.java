package tradingz.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tradingz.firstproject.models.Stock;

public interface StockRespository extends CrudRepository<Stock, Integer> {
}
