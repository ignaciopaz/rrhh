# UTN FRRO - Asignatura: Diseño de Sistemas.
## RRHH
Aplicación de ejemplo con Spring para agendar entrevistas con candidatos según los conocimientos requeridos.
- Link para ver la aplicación online: [https://utn-frro-ds-rrhh.herokuapp.com/](https://utn-frro-ds-rrhh.herokuapp.com/)

## Importar el proyecto en Eclipse
Para importa el proyecto en Eclipse se deben seguir los siguientes pasos:
1. Ir Menú File > Import > Git > Projects from Git.
   - Seleccionar "Clone URI".
	 - URI: [https://github.com/ignaciopaz/rrhh](https://github.com/ignaciopaz/rrhh)
	 - HOST: github.com
	 - Repository Path: /ignaciopaz/rrhh
   - Clic en Next.
   - Seleccionar "Import Existing Eclipse Project".
   - Clic en Next.
   - Clic en Finish.

## Para ejecutar la aplicación 
1. Ir al Paquete edu.utn.frro.ds.reverseengineering.rrhh.
2. Clic derecho en **Application.java** y hacer **Run as Java Application**.
3. Abrir el browse en [http://localhost:8080/](http://localhost:8080/)

## Como ver la base de datos H2
Para ver base de datos H2 de la aplicación:
1. En el brower ir a: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. En **"JDBC URL"** ingresar: **jdbc:h2:mem:testdb**
3. Clic en **"Connect"**
