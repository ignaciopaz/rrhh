# UTN FRRO - Asignatura: Diseño de Sistemas.
# RRHH
Aplicación de ejemplo con Spring para agendar entrevistas con candidatos según los conocimientos requeridos.
- Link para ver la aplicación online: [https://utn-frro-ds-rrhh.herokuapp.com/](https://utn-frro-ds-rrhh.herokuapp.com/)

## Imporar el proyecto en Eclipse
- Ir Menú File>Import>Git>Projects from Git
  - Clone URI
	- URI: https://github.com/ignaciopaz/rrhh
	- HOST: github.com
2. Repository Path: /ignaciopaz/rrhh
Next
Import Existing Eclipse Project
Next
Finish

Para ejecutar 
Ir a Paquete edu.utn.frro.ds.reverseengineering.rrhh
Clic derecho en Application.java y hacer Run as Java Application

Ver base de datos H2:
En el brower ir a: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Connect
