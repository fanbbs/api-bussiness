#first java application

FROM dongjianbin/jdk8:v1.0

ADD spring-boot-api-project-seed-1.0.jar /opt/jar/
COPY /root/locallib/packfile.dat /opt/lib/

ENV JAVA_HOME /usr/local/src/jdk1.8.0_181
ENV PATH $PATH:$JAVA_HOME/bin

CMD ["java","-jar","/opt/jar/spring-boot-api-project-seed-1.0.jar"]