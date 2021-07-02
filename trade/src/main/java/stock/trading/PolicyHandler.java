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
    @Autowired TradeRepository tradeRepository;
    @Autowired BidRepository bidRepository;
    @Autowired AskRepository askRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRequested_AcceptBid(@Payload BidRequested bidRequested){

        if(!bidRequested.validate()) return;

        System.out.println("\n\n##### listener AcceptBid : " + bidRequested.toJson() + "\n\n");



        // Sample Logic //
        // Trade trade = new Trade();
        // tradeRepository.save(trade);
        // Bid bid = new Bid();
        // bidRepository.save(bid);
        // Ask ask = new Ask();
        // askRepository.save(ask);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAskRequested_AcceptAsk(@Payload AskRequested askRequested){

        if(!askRequested.validate()) return;

        System.out.println("\n\n##### listener AcceptAsk : " + askRequested.toJson() + "\n\n");



        // Sample Logic //
        // Trade trade = new Trade();
        // tradeRepository.save(trade);
        // Bid bid = new Bid();
        // bidRepository.save(bid);
        // Ask ask = new Ask();
        // askRepository.save(ask);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
