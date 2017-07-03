##Configurazione

Importare il progetto in un IDE, impostare le credenziali di MongoDB 
in source `src/resources/application.properties`

##Run

1)Avviare il progetto da IDE

2)In alternativa creare il jar del progetto mediante il comando `mvn install` nella
direcotry contenente il file `pom.xml` ed eseguire:

java -jar -Dspring.config.location=/path_to_file/application.properties jar_name.jar 