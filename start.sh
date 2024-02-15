export JAVA_HOME=/usr/lib/jvm/java-21-openjdk/

# A delayed test query
sleep 15 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/order/1" &
sleep 16 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/order/3" &
sleep 17 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/order/5" &

sleep 18 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/composite/1" &
sleep 19 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/composite/3" &
sleep 20 && echo $'\nRunning a test query: ' && curl "http://localhost:7080/composite/5" &

# Put up the server
./mvnw spring-boot:run
