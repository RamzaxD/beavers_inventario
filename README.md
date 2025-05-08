# beavers_inventario
Prueba tecnica con: MySQL + SpringBoot + ReactTs

• IDE utilizado: Microsoft Visual Studio
• Lenguaje de Programacion (Backend): JAVA 21.0.7 2025-04-15 LTS
• Lenguaje de Programacion (FRONTEND): REACT 19.1.2 / TypeScript 5.8.3
• DBMS utilizado: MySQL Server 8.0.42

• Lista de pasos para correr la aplicación.
1.- Clona el repo
  git clone https://github.com/RamzaxD/beavers_inventario.git
  
2.- Entra a la carpeta del front para instalar dependencias:
  cd front/inventario
  
3.- Ejecuta en la terminal la instalacion de dependencias:
npm install / bun install

4.- Desde la carpeta raiz del front: front/inventario
Ejecutar en la terminal para levantar el front: npm run dev / bun run dev

5.- Para el back tener instalado:
JAVA 21.0.7 2025-04-15 LTS
MAVEN 3.9.9

6.- Configuracion de variables de entorno para MySQL:

spring.application.name=inventario.crud
server.port=4000 //remplazar puerto si esta ocupado por uno libre 

# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:(Numero de puerto donde se encuentra la DB de MySQL)/inventario?useSSL=false&serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true
spring.datasource.username=(tu usuario para inicio de sesion de MySQL)
spring.datasource.password=(tu Password de inicio de sesion de MYSQL)
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

NOTA.- Necesario crear una base de datos llamada inventario o remplazar el nombre de la variable por otra base de datos ya hecha para que la api cree las tablas por si sola.

7.- Ejecutar en la terminal desde la carpeta raiz del back: inventario.crud/
mvn clean install   # Compila y genera el .jar
mvn spring-boot:run # Ejecuta el proyecto

8.- Para ejecutar la app hay que dejar ejecutando el back, tener la sesion abierta en MySQL para poder hacer los cambios pertinentes en la base de datos y ejecutar el front.
