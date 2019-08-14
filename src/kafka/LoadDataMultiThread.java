package kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

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

    static void runProducer(final int startIndex, final int endIndex, final int threadNumber) throws Exception {
        final Producer<Long, String> producer = createProducer();


        try {
            for (int index = startIndex; index <= endIndex; index++) {
                final ProducerRecord<Long, String> record =
                        new ProducerRecord<Long, String>(TOPIC, "Thread " + threadNumber + " Message " + index);

                RecordMetadata metadata = producer.send(record).get();
                System.out.printf("sent record(key=%s value=%s)\n", record.key(), record.value());

            }
        } finally {
            producer.flush();
            producer.close();
        }
    }

    public static void main(String... args) {


        try {

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        runProducer(1, 10, 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        runProducer(11, 20, 2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
            t2.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
