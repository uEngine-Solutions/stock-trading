package stock.trading;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Request_table")
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Float price;
    private String item;
    private String accountId;
    private String status;
    private Boolean bid;
    private Double quantity;

    @PostPersist
    public void onPostPersist(){
        BidRequested bidRequested = new BidRequested();
        BeanUtils.copyProperties(this, bidRequested);
        bidRequested.publishAfterCommit();

        AskRequested askRequested = new AskRequested();
        BeanUtils.copyProperties(this, askRequested);
        askRequested.publishAfterCommit();

        Sold sold = new Sold();
        BeanUtils.copyProperties(this, sold);
        sold.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){
        Bought bought = new Bought();
        BeanUtils.copyProperties(this, bought);
        bought.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
        // Get request from Trade
        //stock.trading.external.Trade trade =
        //    Application.applicationContext.getBean(stock.trading.external.TradeService.class)
        //    .getTrade(/** mapping value needed */);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Boolean getBid() {
        return bid;
    }

    public void setBid(Boolean bid) {
        this.bid = bid;
    }
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }




}
