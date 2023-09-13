<h1 align="center">Desafio Soporte - Nicolas Gauna</h1>

Mas que AGRADECIDO por la oportunidad de mostrar mis habilidades en este desafio.

### Acerca del Proyecto

Antes que nada disculpas por no cumplir con todos los puntos del desafio, voy a ir explicando los puntos mas abajo. Pero de igual manera, queda en evidencia mis conocimientos del tema.

Pero la idea inicial fue la de crear un API para la gestion de Clientes (Almacenados en la tabla **test.persona**) y gestion de Administradores (Almacenados en la tabla **test.usuario**). Los Administradores lo dividimos en 2 tipos de roles: ROLE_ADMIN y ROLE_CONSULTOR.

Logramos crear la interfaz grafica para la gestion de clientes pero nos quedamos cortos para la interfaz de gestion de los administradores. Aun asi, queda en evidencia mi conocimiento del tema pero me faltan pulir detalles que muy rapidamente ire perfeccionando al paso que realice desarrollos.

### Tecnologias utilizadas:
**1. BackEnd**
* Para el BackEnd utilizamos las tecnologias solicitadas en el README anterior (Java y Spring) y tambien utilizamos las librerias de Spring Security para el encriptamiento del password y el manejo de roles.

**2. FrontEnd**

Para el FrontEnd utilizamos las tecnologias de:
* Thymeleaf
* jQuery
* Bootstrap
* HTML5

### Instruccion a tener en cuenta
**1. Persistencia de Datos**
* Para la persistencia de datos utilizamos la base de datos MySQL, motivo por el que sera necesario ejecutar los DML almacenados en la carpeta **/DML** del proyecto.
* En caso de querer utilizar otro motor de base de datos realizar las modificaciones pertinentes en los archivos DML y en el archivo **application.properties** del proyecto.

**2. Inicio de sesion**
* En el DML **04.INSERT-INTO-usuario.sql** relizamos un insert con los usuarios para el inicio de sesion. Insertamos 2 usuarios: **admin** y **consulta** y ambos tienen la misma contraseña: **123**
* Me quede corto a la hora de intentar crear una interfaz grafica para la administracion de usuarios, motivo por el que si queremos insertar un nuevo Usuario Administrador debemos insertar manualmente en la tabla **test.usuario**
* Como utilizamos spring-security para el encriptado de contraseña debemos utilizar la clase **EncriptarPassword.java** ubicado en el paquete com.somosetica.util. Y en la variable **password** asignar la contraseña que queremos que posea el Administrador.

### Test Unitarios
**1. Capa de Autenticacion:**
* Creamos una vista de login el cual impide que se puedan ver los clientes en caso de que no se inicie sesion.
* En caso de que el usuario no ingrese las credenciales correctas le impide avanzar a la lista de clientes

**2. Capa de Autorizacion: ROLE_ADMIN**
* Inicamos sesion con el usuario admin con el pass 123
* Se visuliza el boton Agregar (Para agregar clientes)
* Se visuliza el boton Editar (Para editar clientes)
* Se visuliza el boton Eliminar (Para eliminar clientes)
* En el footer se visualiza el nombre del usuario y los roles que posee. Se debe visualizar que el usuario posea el rol ROLE_ADMIN y ROLE_CONSULTOR

**3. Capa de Autorizacion: ROL_CONSULTOR**
* Inicamos sesion con el usuario consulta con el pass 123
* NO SE DEBE VISUALIZAR el boton Agregar (Para agregar clientes)
* NO SE DEBE VISUALIZAR el boton Editar (Para editar clientes)
* NO SE DEBE VISUALIZAR el boton Eliminar (Para eliminar clientes)
* En el footer se visualiza el nombre del usuario y los roles que posee. Se debe visualizar que el usuario posea el rol ROLE_CONSULTOR

**4. Validacion de datos:**
* Inicamos sesion con el usuario admin con el pass 123
* Realizamos un clic en el boton Agregar y se despliega un modal con el formulario para agregar un nuevo cliente. Los campos obligatorios se resaltan en color rojo (nombre, apellido, email, saldo, contraseña, estado) y los campos opcionales en color verde.
* Realizamos un clic en el boton Agregar y se despliega un modal con el formulario para agregar un nuevo cliente. Los campos obligatorios se resaltan en color rojo (nombre, apellido, email, saldo, contraseña, estado) y los campos opcionales en color verde.
* Realizamos un clic en el boton Editar y nos debe impedir guardar los cambios en caso de que alguno de los campos se encuentren vacios.