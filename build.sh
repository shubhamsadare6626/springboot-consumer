mvn clean compile package -DskipTests && \
docker-compose down && \
docker build -t  personal/springboot-consumer . && \
docker-compose up -d && \
docker logs -f springboot-rabbitmq-consumer 
