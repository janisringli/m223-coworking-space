# Übungsprojekt: Coworkingspace

Coworkingspace ist ein multiusersystem, welches mit Quarkus entwickelt wird.

## Repository
https://github.com/janisringli/m223-coworking-space


## Login
/auth/login
mitglied: username: user, passwort: user
admin: username: admin, passwort: admin


## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
2. Stelle sicher, dass Docker installiert ist und läuft.
3. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
4. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
5. Öffne das Projekt mit Visual Studio Code.
6. Öffne das Projekt im Entwicklungscontainer.
7. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
8. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird die PostgreSQL-Datenbank verwendet. Daten werden importiert von import.sql