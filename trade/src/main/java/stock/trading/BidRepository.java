package stock.trading;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="bids", path="bids")
public interface BidRepository extends PagingAndSortingRepository<Bid, Long>{


}
