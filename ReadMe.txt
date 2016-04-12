EAI Example
===================

--- Aufgabe ---

1. Schritt: Git Repository erstellen
Gehen Sie im Browser auf http://gitp001.srv.ha3.dir.muenchen.de/ (wenn
nur Zugang von extern vorhanden ist, dann geht auch bitbucket) und
erstellen Sie ein Repository. Klonen Sie dieses (leere) Repository in
Ihren lokalen Projektordner ($P_HOME) mit "git clone". Sie können
hierfür z.B. ~/workspace/demo verwenden.

Geben Sie folgenden Personen Zugriff auf das Repository:
claus.straube (claus.straube@muenchen.de)
robert.jasny (robert.jasny@muenchen.de)

Schicken Sie bitte eine kurze Mail mit der Repository URL an die beiden
oben genannten E-Mail Adressen.

Bei bitbucket bitte eine Mail an claus.straube@muenchen.de. Dann klären
wir das weitere vorgehen.

2. Schritt: Projekt erstellen
Erstellen Sie in $P_HOME (also z.B. ~/workspace/demo) mit Hilfe von
Apache Maven die initiale Projektstruktur. Nutzen Sie hierzu den
camel-archetype-spring-boot Archetype.

3. Schritt: Rest Endpoint erstellen
Erstellen Sie mit Hilfe der entsprechenden Spring Annotationen einen
Rest Endpunkt, an den eine Payload per http POST gesendet werden kann.

Struktur der Payload:
{
  "amount": 10,
  "message": "Hello World"
}

Testen Sie den Endpunkt durch entsprechende Unit Tests.

4. Schritt: Route erstellen
Erstellen Sie eine Camel Route, die per „direct“ Endpunkt ansprechbar
ist. Prüfen Sie innerhalb der Route (es können hierfür auch mehr als
eine Route erstellt werden), ob der Wert im Element „amount“
größer/gleich oder kleiner 10 ist. Loggen Sie die Entscheidung innerhalb
der Route auf die Console. Schreiben Sie anschließend die Payload in
eine Datei. Alle Payloads kleiner 10 in einen Ordner „lower“, den Rest
in einen Ordner „greater“.

Testen Sie die Route(n) durch entsprechende Unit Tests.

5. Schritt: Rest Endpunkt und Route verbinden
Rufen Sie die Route (direct Endpunkt) aus Ihrem Rest Controller auf und
übergeben Sie ihm die empfangene Payload.

Testen Sie diese Verbindung durch einen Integrationstest.

6. Schritt: Bauen und starten
Bauen Sie das Projekt über Maven. Starten Sie Spring Boot über die
Kommandozeile (java -jar...). Schicken Sie entsprechende Testnachrichten
über einen Testclient (z.B. ein Browser Plugin wie RESTClient). Prüfen
Sie, ob die Nachrichten in den richtigen Ordner gelegt wurden.

7. Schnritt: 10 Minuten Präsentation Ihres Arbeitsergebnisses
Präsentieren Sie Ihr Arbeitsergebnis kurz in Form eines Standup
Meetings. Erzählen Sie kurz, was Sie gemacht haben, wie lange Sie
gebraucht haben, auf welche Probleme Sie gestoßen sind und wie sie
gelöst wurden. Gehen Sie darauf ein, was sie als nächstes machen würden,
um die Anwendung zu verbessern. Bei der Präsentation ist *kein* Beamer
zu verwenden. Um komplexe Sachverhalte zu erklären, steht ein Whiteboard
zur Verfügung.

--- Aufgabe --- 

You will need to compile this example first:
  mvn install

To run the example type
  mvn spring-boot:run

You can also execute the fat WAR directly:

  java -jar target/camel-eaidemo-1.0-SNAPSHOT.war

You will see the message printed to the console every second.

To stop the example hit ctrl + c

For more help see the Apache Camel documentation

    http://camel.apache.org/

