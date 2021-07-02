package stock.trading;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset, Long> {

    List<Asset> findByAccountId(String accountId);
    List<Asset> findByAccountId(String accountId);

}