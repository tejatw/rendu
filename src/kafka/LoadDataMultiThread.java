package kafka;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

import java.util.Properties;


public class LoadDataMultiThread {

    private final static String TOPIC = "promo-product-audit";
    private final static String BOOTSTRAP_SERVERS =
            "localhost:9092";

    private static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "consumer-1");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    static void runProducer(final int sendMessageCount) throws Exception {
        final Producer<Long, String> producer = createProducer();


        try {
            for (int index = 1; index < 100; index++) {
                final ProducerRecord<Long, String> record =
                        new ProducerRecord<Long, String>(TOPIC, "Message " + index);

                RecordMetadata metadata = producer.send(record).get();
                System.out.printf("sent record(key=%s value=%s) " +
                                "meta(partition=%d, offset=%d)\n",
                        record.key(), record.value(), metadata.partition(),
                        metadata.offset());

            }
        } finally {
            producer.flush();
            producer.close();
        }
    }

    public static void main(String... args) {


        try {
            runProducer(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*kafkaProducer.initTransactions();
        try {
            kafkaProducer.beginTransaction();

            for (int messageStartCount = 1; messageStartCount <= 100; messageStartCount++) {

                kafkaProducer.send(
                        new ProducerRecord<String, String>("promo-product-audit", "", "Message " + messageStartCount),
                        new Callback() {
                            @Override
                            public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                                if (exception != null) {
                                    System.out.println("Error publishing message no " + recordMetadata.toString());
                                }
                            }
                        }
                );
            }
            kafkaProducer.commitTransaction();
            kafkaProducer.flush();
        } catch (KafkaException ke) {

            ke.printStackTrace();
        }*/

    }

    /*@AllArgsConstructor
    public static class LoadKafka{

        private Producer kafkaProducer;

        public void produce(int startCount, int endCount) throws InterruptedException{

            kafkaProducer.initTransactions();
            try {
                kafkaProducer.beginTransaction();

                for (int messageStartCount = startCount; messageStartCount <= endCount; messageStartCount++) {

                    kafkaProducer.send(
                            new ProducerRecord<String, String>("promo-product-audit", "", "Message " + messageStartCount),
                            new Callback() {
                                @Override
                                public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                                    if (exception != null) {
                                        System.out.println("Error publishing message no " + recordMetadata.toString());
                                    }
                                }
                            }
                    );
                }
                kafkaProducer.commitTransaction();
                kafkaProducer.flush();
            } catch (KafkaException ke) {

                ke.printStackTrace();
            }

        }
    }*/
}
