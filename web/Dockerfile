FROM tomcat:10.1.6-jdk17

ARG version
ARG hikaricp_URL
ARG sfl4j_api_URL
ARG mysql_connector_j_URL

WORKDIR /usr/local/tomcat

# JDBC datasource configuration
ADD tomcat/conf/server.xml conf/
ADD tomcat/conf/context.xml conf/

# required to start HikariCP inside Apache Tomcat
RUN wget -O lib/hikaricp.jar ${hikaricp_URL}
RUN wget -O lib/slf4j-api.jar ${sfl4j_api_URL}
RUN wget -O lib/mysql-connector-j.jar ${mysql_connector_j_URL}

ADD target/web-${version}.war /usr/local/tomcat/webapps/demo.war

EXPOSE 8080