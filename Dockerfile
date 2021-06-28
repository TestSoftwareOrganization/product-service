 FROM openjdk:11
 VOLUME /tmp
 ARG JAR_FILE
 ENV PORT 8014
 EXPOSE 8014
 COPY ${JAR_FILE} productservice-0.0.1-SNAPSHOT.jar
 ENTRYPOINT ["java","-jar","/productservice-0.0.1-SNAPSHOT.jar"]

 #Build image
 #docker build --build-arg JAR_FILE=build/libs/*.jar -t product-service .

 #Run image
 #docker run -p 8014:8014 user-service


 #Run shell inside
 #docker exec -ti config-server /bin/sh
# docker run --name eshop_database -e POSTGRES_PASSWORD=kolev -p 5432:5432 -d postgres
#eval $(minikube docker-env)

#docker pull webcenter/activemq:5.15.2