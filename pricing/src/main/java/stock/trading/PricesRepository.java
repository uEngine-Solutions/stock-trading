package stock.trading;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PricesRepository extends CrudRepository<Prices, Long> {


}