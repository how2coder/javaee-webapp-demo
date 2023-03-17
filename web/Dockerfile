FROM tomcat:10.1.6-jdk17

ARG version
ADD target/web-${version}.war /usr/local/tomcat/webapps/demo.war

EXPOSE 8080