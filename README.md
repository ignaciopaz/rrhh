# UTN FRRO - Asignatura: Diseño de Sistemas.
## RRHH
Aplicación académica de ejemplo con Spring para agendar entrevistas con candidatos según los conocimientos requeridos.
- Link para ver la aplicación online: [https://utn-frro-ds-rrhh.herokuapp.com/](https://utn-frro-ds-rrhh.herokuapp.com/) (Puede tardar en cargar la primera vez).

## Software necesario para correr el proyecto
- Descargar e instalar JDK [Java development kit 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) o posterior.
- Descargar e instalar la última versión de [Eclipse](https://www.eclipse.org/downloads/) IDE para Java.

## Configurar Eclipse
1. Ir a menú Window > Preferences
2. Ir a Java > Installed JREs
3. Verificar que el path de Java sea el de donde se instaló JDK, ejemplo: **C:\Java\jdk1.8.0_74**
4. Si dice JRE, Remove y agregar uno nuevo
   - Elegir Standard VM
   - En JRE home, agregar el Path Correcto de la instalación de . Ejemplo: **C:\Java\jdk1.8.0_74**
   - Finish

## Importar el proyecto en Eclipse
Para importa el proyecto en Eclipse se deben seguir los siguientes pasos:
1. Ir **Menú File > Import > Git > Projects from Git**.
2. Seleccionar **"Clone URI"** e ingresar los siguientes datos:
   - URI: [https://github.com/ignaciopaz/rrhh.git](https://github.com/ignaciopaz/rrhh.git)
   - HOST: github.com
   - Repository Path: /ignaciopaz/rrhh
3. Clic en Next.
4. Seleccionar **"Import Existing Eclipse Project"**.
5. Clic en Next.
6. Clic en Finish.

## Descargar dependencias
Antes de ejecutar el proyecto por primera vez se deben descargar las dependencias a través de Maven:
1. Ir al archivo **pom.xml**
2. Hacer clic derecho sobre el mismo y ejecutar **Run as > Maven Clean** 
3. Volver a hacer clic derecho sobre el pom.xml y ejecutar **Run as > Maven Install**.

## Correr la aplicación
Para ejecutar la aplicación:
1. Terminar cualquier aplicación que esté corriendo dentro de Eclipse.
2. Ir al Paquete edu.utn.frro.ds.reverseengineering.rrhh. 
3. Clic derecho en **Application.java** y hacer **Run as Java Application**.
4. Abrir el browser en [http://localhost:8080/](http://localhost:8080/)

## Como ver la base de datos H2
Para ver la consola de la base de datos [H2](http://www.h2database.com/) de la aplicación:
1. En el brower ir a: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. En **"JDBC URL"** ingresar: **jdbc:h2:mem:testdb**
3. Clic en **"Connect"**
