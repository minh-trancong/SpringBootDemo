FROM sfat/liquibase

COPY ./src/main/resources/db /liquibase/db
COPY docker/liquibase/bin/entrypoint.sh /liquibase/bin/entrypoint.sh

USER root

RUN apt-get update && \
    apt-get install -y dos2unix && \
    chmod a+x /liquibase/bin/entrypoint.sh && \
    wget -q "https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.21/mysql-connector-java-8.0.21.jar" -O /liquibase/mysql-connector-java.jar && \
    dos2unix /liquibase/bin/entrypoint.sh && \
    rm -rf /var/lib/apt/lists/*

USER liquibase

ENTRYPOINT ["bin/entrypoint.sh"]
