FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-discovery-1.0.0.jar abc.jar
EXPOSE 5555
ENV JAVA_VALUES="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java ${JAVA_VALUES} -jar abc.jar" ]
