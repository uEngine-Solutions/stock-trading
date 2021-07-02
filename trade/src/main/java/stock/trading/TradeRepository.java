package stock.trading;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="trades", path="trades")
public interface TradeRepository extends PagingAndSortingRepository<Trade, Long>{


}
