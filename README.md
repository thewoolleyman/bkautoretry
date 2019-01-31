# Buildkite Job Failure Auto-Retry

## Overview

Automatically retries a failed Buildkite job, to deal with test flakes
due to infrastructure or container failure, etc.

## DB Setup

### Postgres

* https://medium.com/@viviennediegoencarnacion/getting-started-with-postgresql-on-mac-e6a5f48ee399

```
$ psql postgres
postgres=# CREATE ROLE bkautoretry WITH LOGIN PASSWORD '';
postgres-# ALTER ROLE bkautoretry CREATEDB;
postgres-# \q

$ psql postgres -U bkautoretry
postgres=> CREATE DATABASE bkautoretry;
```

### Liquibase

* https://www.liquibase.org/
* Install via homebrew. Be sure to set LIQUIBASE_HOME as directed by `brew info`

```
liquibase update
```

## References

References for tools/architecture used:

* Spring Boot init:
  * https://start.spring.io/
* Initial reactive rest setup and tests:
  * https://spring.io/guides/gs/reactive-rest-service/
  * https://dzone.com/articles/spring-webflux-getting-started
  * https://github.com/sdeleuze/webflux-kotlin-web-tests
* DB access
  * https://github.com/bastman/spring-kotlin-exposed
  * https://phauer.com/2017/do-it-yourself-orm-alternative-hibernate-drawbacks/
  * https://www.baeldung.com/spring-jdbc-jdbctemplate
  * (TODO: explore jsonb vs json): https://www.compose.com/articles/faster-operations-with-the-jsonb-data-type-in-postgresql/
