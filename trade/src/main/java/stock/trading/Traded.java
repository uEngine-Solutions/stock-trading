package stock.trading;

public class Traded extends AbstractEvent {

    private Long id;
    private String item;
    private Double price;
    private Long bidRequestId;
    private Double quantity;
    private Long askRequestId;

    public Traded(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Long getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Long bidRequestId) {
        this.bidRequestId = bidRequestId;
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
