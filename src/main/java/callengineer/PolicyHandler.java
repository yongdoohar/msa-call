package callengineer;

import callengineer.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired CallRepository callRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBusinessTripStarted_EngineerStatusChange(@Payload BusinessTripStarted businessTripStarted){

        if(!businessTripStarted.validate()) return;

        System.out.println("\n\n##### listener EngineerStatusChange : " + businessTripStarted.toJson() + "\n\n");


        

        // Sample Logic //
        // Call call = new Call();
        // callRepository.save(call);

    }


}


