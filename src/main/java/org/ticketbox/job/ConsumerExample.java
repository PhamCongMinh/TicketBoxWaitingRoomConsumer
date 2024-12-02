package org.ticketbox.job;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class ConsumerExample {
    private static final Logger log = LoggerFactory.getLogger(ConsumerExample.class.getSimpleName());

    public static void main(String[] arg) {
        log.info("Consumer start running");

        String groupId = "group1";
        String topic = "second_topic";
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", groupId);
        properties.setProperty("auto.offset.reset", "earliest");
        properties.setProperty("partition.assignment.strategy", CooperativeStickyAssignor.class.getName());
//        properties.setProperty("group.instance.id",    );

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                consumer.wakeup();

                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            consumer.subscribe(Arrays.asList(topic));

            while (true) {
                log.info("Polling");

                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));

                for (ConsumerRecord<String, String> record : consumerRecords) {
                    log.info("Key: " + record.key() + "\n"
                            + "Value: " + record.value() + "\n"
                            + "Topic: " + record.topic()
                    );
                }

            }

        }catch (WakeupException e) {
            log.info("Consumer is starting shutdown");
        } catch (Exception e) {
            log.error("Unexpected exception", e);
        } finally {
            consumer.close();
        }

    }
}
