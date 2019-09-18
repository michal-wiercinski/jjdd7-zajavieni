FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin 123#zajava --silent

ADD target/3cityevent.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]