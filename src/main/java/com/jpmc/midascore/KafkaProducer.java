import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.jpmc.midascore.foundation.Transaction;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Transaction transaction) {
        kafkaTemplate.send("midas-transactions", transaction);
    }
}
