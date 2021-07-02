package stock.trading;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Prices_table")
public class Prices {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private String item;
        private Double price;


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

}
