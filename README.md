# TP_1-Poc-Strategy

# 1. Que es Maven

Maven es una herramienta de software para la gesti�n y construcci�n de proyectos Java, con un modelo de configuraci�n de construcci�n basado en un formato XML.
Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros m�dulos y componentes externos, y el orden de construcci�n de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilaci�n del c�digo y su empaquetado.

Una caracter�stica clave de Maven es que est� listo para usar en red. El motor incluido en su n�cleo puede din�micamente descargar plugins de un repositorio, el mismo repositorio que provee acceso a muchas versiones de diferentes proyectos Open Source en Java, de Apache y otras organizaciones y desarrolladores.

# 2. POM que significa y para que sirve

POM significa Project Object Model. Es una representacion XML de un projecto Maven, el cual se utiliza para describir el proyecto de software a construir, sus dependencias de otros m�dulos y componentes externos, y el orden de construcci�n de los elementos.

# 3. Diferencia entre Archetype y Artifacld

Archetype:
Archetype es un toolkit para la creaci�n de plantillas de proyectos Maven. 
Un archetype se define como un patr�n o modelo original a partir del cual se hacen todas las dem�s cosas del mismo tipo. Los nombres se adaptan a medida que intentamos proporcionar un sistema que proporcione un medio consistente para generar proyectos de Maven. Archetype ayudar� a los autores a crear plantillas de proyectos Maven para los usuarios, y proporciona a los usuarios los medios para generar versiones parametrizadas de esas plantillas de proyectos.

Artifacid:
Es el nombre del Jar sin version, osea es el nombre unico del proyecto. Si lo creas, podes elegir el nombre que desees con letras min�sculas y sin s�mbolos extra�os. Si se trata de un Jar de un tercero, debes tomar el nombre del Jar tal como se distribuye.

# 4. Explique los siguientes goals de Maven; [clean, package, install, compile]

Clean: 
Para limpiar el proyecto y eliminar todos los archivos generados por la compilaci�n anterior.

Package:
Par empaquetar el codigo fuente en el formato deseado.

Install:
Para instalar el paquete en un repositorio local.

Compile:
Para compilar en codigo fuente.

# 5. Explique los siguientes Scopes; [compile, provide, runtime, test, system]

Compile:
Este es el Scope predeterminado, usado si no se especifica ninguno. 
Las dependencias de compilaci�n est�n disponibles en todos los classpaths de un proyecto. Adem�s, esas dependencias se propagan a proyectos dependientes.

Provide:
Es muy parecido a Compile, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de ejecuci�n.
Este Scope solo est� disponible en el classpath de compilaci�n y test, y no es transitivo.

Runtime:
Este Scope indica que la dependencia no es necesaria para la compilaci�n, pero si para la ejecuci�n.
Se encuentra en el classpath de runtime y test, pero no en el de compilaci�n.

Test:
Este Scope indica que la dependencia no es requerida para el uso normal de la aplicaci�n, y solo est� disponible para las fases de compilaci�n de test y ejecuci�n. Este Scope no es transitivo.

System:
Este Scope es similar a Provide, excepto que se debe proporcionar el JAR que lo contiene expl�citamente. 
El artifact siempre est� disponible y no se busca en un repositorio.
