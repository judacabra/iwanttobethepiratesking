En el proyecto hay dos carpetas y un archivo:
[Carpeta] pirates = backend desarrollado en spring boot 3.9.9 y JDK 21 (port :8081, database MYSQL).
[Carpeta] pirates_front = frontend desarrollado en php y javascript.
[Archivo] SQL.sql = Archivo que contiene los scripts para ejecutar en MySQL.

El backend se ejecuta en bash con el siguiente command = ./mvnw spring-boot:run
El frontend se ejecuta en un servidor web HTTP como XAMPP iniciando MySQL y Apache.

A continuación el paso a paso para la ejecución del proyecto.

1. Iniciar el Apache (o similar) y el MySQL.
2. Ejecutar los scripts dentro del archivo SQL.sql
3. Ejecutar en bash el command para iniciar el backend.
4. Ir a la ruta del navegador = localhost/pirates_front.
5. Loguarse con el user #1 con credenciales descritas en el archivo SQL.sql para validar el perfil administrator.
6. Loguarse con el user #2 con credenciales descritas en el archivo SQL.sql para validar el perfil client.

Despues del paso 5 (Usuario Admin): 
Dentro de la app tendras un navbar con 3 links (Usuarios, Tripulaciones y Perfil).
En usuarios veras la lista de los usuarios insertados en base de datos.
En tripulaciones veras la lista de tripulaciones creadas en base de datos las cuales podras:
  Insertar una nueva tripulación.
  Modificar una tripulación existente.
  Eliminar (Si tiene tripulantes no se puede eliminar y te lo avisa).  
  Insertar tripulantes (Characters) desde base de datos o desde la api de One Piece.  
En perfil apareceran tus datos de usuario logueado y el boton de cerrar sesión.

Despues del paso 6 (Usuario Client): 
Dentro de la app tendras un navbar con 2 links (Mi Tripulación y Perfil).
En Mi tripulación veras la información de tu tripulación que podras:
  Insertar tu tripulación.
  Modificar tu tripulación.  
  Insertar tripulantes (Characters) desde base de datos o desde la api de One Piece.
En perfil apareceran tus datos de usuario logueado y el boton de cerrar sesión.
