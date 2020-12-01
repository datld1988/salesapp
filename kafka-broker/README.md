1. Installation and Running of Apache Kafka message broker
Apache Kafka is based on Zookeeper. Before starting the kafka server, we must run zookeeper server.

1.1. Install on the windows:
#Extract file kafka_2.12-2.2.1.zip in this folder
#Go to \bin\windows folder and then enter bellow line to install and run zookeeper server:
zookeeper-server-start.bat ..\..\config\zookeeper.properties

#Go to \bin\windows folder and then enter bellow line to install and run Kafka:
Kafka-server-start.bat ..\..\config\server.properties


1.2. Install on the mac/linux:
#Extract file kafka_2.12-2.2.1.zip in this folder
#Go to /bin folder and then enter bellow line to install and run zookeeper server:
./zookeeper-server-start.sh ../config/zookeeper.properties

#Go to /bin folder and then enter bellow line to install and run Kafka:
./kafka-server-start.sh ../config/server.properties


1.3. Install by docker
# run docker-compose.yml as bellow:
docker-compose up kafka



2. Creating topics
# Run bellow line to create a topic
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic zipkin
# Check create topic
./kafka-topics.sh --bootstrap-server localhost:9092 --list




3. Consuming topics
# To produce messages to Kafka topic use the below line
./kafka-console-producer.sh --broker-list localhost:9092 --topic zipin
# From Apache Kafka 2.5 both options are supported --broker-list and --bootstrap-server. Suggested one is --bootstrap-server
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic zipkin

# To consume the messages in Kafka topic use the below line
./kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic zipkin \
    --from-beginning



