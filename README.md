# recruitment_task_r
Aplikacja wymaga JDK w wersji 1.8 lub wyższej.

Aplikacja korzysta z:
-Apache Maven Compiler Plugin (v2.5.1)
-Apache Tomcat Maven Plugin (v2.1)

Aby uruchomić serwer korzystając z linii poleceń, należy zainstalować „Apache Maven” (testowane na wersji 3.5.3) - https://maven.apache.org/download.cgi

Możliwe jest uruchomienie serwera, podając URL-a jako argument przy uruchomieniu w linii poleceń.

W celu uruchomienia serwera (korzystając z linii poleceń) wraz z testami należy przejść do folderu z projektem, a następnie użyć komendy:

mvn clean install tomcat7:run -Durl="URL do pliku wejściowego"

W celu uruchomienia samych testów należy przejść do folderu z projektem, a następnie użyć komendy:

mvn test

Serwer umożliwia wykonywanie m.in. zapytań:
GET:

 http://localhost:8080/engines?pressure_threshold=1000&temp_threshold=0
 
 http://localhost:8080/sensors
 
POST:

 http://localhost:8080/sensors/3142 -H "Content-Type: application/json" -d '{"operation": "increment", "value": "5"}'
 

