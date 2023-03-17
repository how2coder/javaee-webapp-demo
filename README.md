# javaee-webapp-demo

To pull all docker images:

```text
docker compose pull
```

To build project:

```text
docker compose run maven-build
```

To build local docker image:

```text
docker compose build
```

To run database:

```text
docker compose up -d db-mysql
```

To run web app:
```text
docker compose up -d web
```

Go to [http://localhost:8080/demo](http://localhost:8080/demo)