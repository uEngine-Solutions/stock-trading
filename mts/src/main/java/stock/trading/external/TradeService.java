
package stock.trading.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="trade", url="http://trade:8080")
public interface TradeService {
    @RequestMapping(method= RequestMethod.GET, path="/trades/{id}")
    public Trade getTrade(@PathVariable("id") Long id);

}

