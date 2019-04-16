# TP_1-Poc-Strategy

# 1. Que es Maven

Maven es una herramienta de software para la gestión y construcción de proyectos Java, con un modelo de configuración de construcción basado en un formato XML.
Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros módulos y componentes externos, y el orden de construcción de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado.

Una característica clave de Maven es que está listo para usar en red. El motor incluido en su núcleo puede dinámicamente descargar plugins de un repositorio, el mismo repositorio que provee acceso a muchas versiones de diferentes proyectos Open Source en Java, de Apache y otras organizaciones y desarrolladores.

# 2. POM que significa y para que sirve

POM significa Project Object Model. Es una representacion XML de un projecto Maven, el cual se utiliza para describir el proyecto de software a construir, sus dependencias de otros módulos y componentes externos, y el orden de construcción de los elementos.

# 3. Diferencia entre Archetype y Artifacld

Archetype:
Archetype es un toolkit para la creación de plantillas de proyectos Maven. 
Un archetype se define como un patrón o modelo original a partir del cual se hacen todas las demás cosas del mismo tipo. Los nombres se adaptan a medida que intentamos proporcionar un sistema que proporcione un medio consistente para generar proyectos de Maven. Archetype ayudará a los autores a crear plantillas de proyectos Maven para los usuarios, y proporciona a los usuarios los medios para generar versiones parametrizadas de esas plantillas de proyectos.

Artifacid:
Es el nombre del Jar sin version, osea es el nombre unico del proyecto. Si lo creas, podes elegir el nombre que desees con letras minúsculas y sin símbolos extraños. Si se trata de un Jar de un tercero, debes tomar el nombre del Jar tal como se distribuye.

# 4. Explique los siguientes goals de Maven; [clean, package, install, compile]

Clean: 
Para limpiar el proyecto y eliminar todos los archivos generados por la compilación anterior.

Package:
Par empaquetar el codigo fuente en el formato deseado.

Install:
Para instalar el paquete en un repositorio local.

Compile:
Para compilar en codigo fuente.

# 5. Explique los siguientes Scopes; [compile, provide, runtime, test, system]

Compile:
Este es el Scope predeterminado, usado si no se especifica ninguno. 
Las dependencias de compilación están disponibles en todos los classpaths de un proyecto. Además, esas dependencias se propagan a proyectos dependientes.

Provide:
Es muy parecido a Compile, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de ejecución.
Este Scope solo está disponible en el classpath de compilación y test, y no es transitivo.

Runtime:
Este Scope indica que la dependencia no es necesaria para la compilación, pero si para la ejecución.
Se encuentra en el classpath de runtime y test, pero no en el de compilación.

Test:
Este Scope indica que la dependencia no es requerida para el uso normal de la aplicación, y solo está disponible para las fases de compilación de test y ejecución. Este Scope no es transitivo.

System:
Este Scope es similar a Provide, excepto que se debe proporcionar el JAR que lo contiene explícitamente. 
El artifact siempre está disponible y no se busca en un repositorio.
