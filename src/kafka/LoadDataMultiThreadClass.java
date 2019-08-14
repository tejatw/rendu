package kafka;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Lookup;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LoadKafka implements Runnable {

    private static String TOPIC = "promo-product-audit";
    private static String BOOTSTRAP_SERVERS =
            "localhost:9092";
    private static String CLIENT_ID = "consumer-1";

    private Producer<Long, String> producer;

    private int startIndex;
    private int endIndex;
    private int threadNumber;

    private Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    public LoadKafka(int startIndex, int endIndex, int threadNumber) {

        producer = createProducer();
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.threadNumber = threadNumber;

    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        try {
            for (int index = startIndex; index <= endIndex; index++) {
                final ProducerRecord<Long, String> record =
                        new ProducerRecord<Long, String>(TOPIC, "Thread " + threadNumber + " Message " + index);

                RecordMetadata metadata = producer.send(record).get();
//                System.out.printf("sent record(key=%s value=%s)\n", record.key(), record.value());

            }
        }
        catch (Exception e){

            e.printStackTrace();
        }
            finally {
            producer.flush();
            producer.close();
        }

        System.out.printf("Time taken by thread %d is %d\n", threadNumber, (System.currentTimeMillis() - startTime));
    }
}

public class LoadDataMultiThreadClass {

    public static void main(String... args) {

        LoadKafka lk1 = new LoadKafka(1, 10000, 1);
        LoadKafka lk2 = new LoadKafka(10001, 20000, 2);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(lk1);
        threadPool.execute(lk2);

        threadPool.shutdown();
    }
}
