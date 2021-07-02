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
public class AssetViewHandler {


    @Autowired
    private AssetRepository assetRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBought_then_CREATE_1 (@Payload Bought bought) {
        try {

            if (!bought.validate()) return;

            // view 객체 생성
            Asset asset = new Asset();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            assetRepository.save(asset);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBought_then_UPDATE_1(@Payload Bought bought) {
        try {
            if (!bought.validate()) return;
                // view 객체 조회
            Optional<Asset> assetOptional = assetRepository.findByItem(bought.getItem());

            if( assetOptional.isPresent()) {
                 Asset asset = assetOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 asset.setAmount(bought.getQuantity());
                // view 레파지 토리에 save
                 assetRepository.save(asset);
                }


                    List<Asset> assetList = assetRepository.findByAccountId(bought.getAccountId());
                    for(Asset asset : assetList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    asset.setAmount(bought.getQuantity());
                // view 레파지 토리에 save
                assetRepository.save(asset);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSold_then_UPDATE_2(@Payload Sold sold) {
        try {
            if (!sold.validate()) return;
                // view 객체 조회
            Optional<Asset> assetOptional = assetRepository.findByItem(sold.getItem());

            if( assetOptional.isPresent()) {
                 Asset asset = assetOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 asset.setAmount(asset.getAmount() - sold.getQuantity());
                // view 레파지 토리에 save
                 assetRepository.save(asset);
                }


                    List<Asset> assetList = assetRepository.findByAccountId(sold.getAccountId());
                    for(Asset asset : assetList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    asset.setAmount(asset.getAmount() - sold.getQuantity());
                // view 레파지 토리에 save
                assetRepository.save(asset);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

