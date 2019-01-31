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

* https://start.spring.io/
* https://spring.io/guides/gs/reactive-rest-service/
* https://dzone.com/articles/spring-webflux-getting-started
* https://github.com/sdeleuze/webflux-kotlin-web-tests