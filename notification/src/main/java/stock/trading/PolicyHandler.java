package stock.trading;

import stock.trading.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSold_SendNotification(@Payload Sold sold){

        if(!sold.validate()) return;

        System.out.println("\n\n##### listener SendNotification : " + sold.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBought_SendNotification(@Payload Bought bought){

        if(!bought.validate()) return;

        System.out.println("\n\n##### listener SendNotification : " + bought.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAskRequested_SendNotification(@Payload AskRequested askRequested){

        if(!askRequested.validate()) return;

        System.out.println("\n\n##### listener SendNotification : " + askRequested.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRequested_SendNotification(@Payload BidRequested bidRequested){

        if(!bidRequested.validate()) return;

        System.out.println("\n\n##### listener SendNotification : " + bidRequested.toJson() + "\n\n");



        // Sample Logic //

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
