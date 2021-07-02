package stock.trading;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="asks", path="asks")
public interface AskRepository extends PagingAndSortingRepository<Ask, Long>{


}
