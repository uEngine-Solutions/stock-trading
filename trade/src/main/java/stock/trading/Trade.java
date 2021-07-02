package stock.trading;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Trade_table")
public class Trade {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bidRequestId;
    private String item;
    private Double price;
    private Double quantity;
    private Long askRequestId;

    @PostPersist
    public void onPostPersist(){
        Traded traded = new Traded();
        BeanUtils.copyProperties(this, traded);
        traded.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Long bidRequestId) {
        this.bidRequestId = bidRequestId;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Long getAskRequestId() {
        return askRequestId;
    }

    public void setAskRequestId(Long askRequestId) {
        this.askRequestId = askRequestId;
    }




}
