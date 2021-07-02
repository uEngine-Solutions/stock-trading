package stock.trading;

import stock.trading.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PricesViewHandler {


    @Autowired
    private PricesRepository pricesRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTraded_then_CREATE_1 (@Payload Traded traded) {
        try {

            if (!traded.validate()) return;

            // view 객체 생성
            Prices prices = new Prices();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            pricesRepository.save(prices);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenTraded_then_UPDATE_1(@Payload Traded traded) {
        try {
            if (!traded.validate()) return;
                // view 객체 조회
            Optional<Prices> pricesOptional = pricesRepository.findByItem(traded.getItem());

            if( pricesOptional.isPresent()) {
                 Prices prices = pricesOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 prices.setPrice(traded.getPrice());
                // view 레파지 토리에 save
                 pricesRepository.save(prices);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

