
# El despertar del héroe
 
Aventura de texto en consola hecha en Java, con un ranking de puntuaciones guardado en XML (validado con DTD), consultado con XPath y publicado como página HTML mediante XSLT y CSS.
 
## Requisitos
 
- **Java 17 o superior** (probado con JDK 27). Se necesita la versión 17 porque el daño se calcula con `Random.nextInt(mínimo, máximo)`.
- Opcional, para la parte XML: `xmllint` y `xsltproc` (paquete libxml2 / libxslt). En Windows no vienen instalados.
## Cómo compilar y ejecutar
 
**Importante:** ejecuta siempre los comandos desde la **carpeta raíz del proyecto**, porque el ranking se guarda en la ruta relativa `datos/ranking.xml`.
 
### Linux / macOS
 
```bash
git clone [URL-DEL-REPOSITORIO]
cd [CARPETA-DEL-PROYECTO]
javac -d bin -sourcepath src src/Main.java
java -cp bin Main
```
 
### Windows (CMD o PowerShell)
 
```bat
git clone [URL-DEL-REPOSITORIO]
cd [CARPETA-DEL-PROYECTO]
javac -encoding UTF-8 -d bin -sourcepath src src/Main.java
java -cp bin Main
```
 
## Estructura del proyecto
 
```
.
├── src/                  Código fuente Java
│   ├── Main.java         Menú, partida y combate
│   ├── Hero.java         Héroe y enemigos
│   ├── Invenatario.java  Inventario de pociones
│   ├── Reg.java          Un registro del ranking (nombre y puntos)
│   ├── Ranking.java      Lista ordenada de registros (máx. 10)
│   └── RankingXML.java   Lectura y escritura del ranking en XML
├── datos/
│   ├── ranking.xml       Ranking guardado
│   ├── ranking.dtd       DTD que define la estructura del XML
│   ├── ranking.xsl       Transformación XSLT
│   ├── ranking.css       Estilos (hoja externa)
│   ├── ranking.html      Página generada
│   └── xpath_test.txt    Cinco consultas XPath
├── .gitignore
└── README.md
```
 
## Reglas del juego
 
- El héroe empieza con **100 puntos de vida** y causa entre **10 y 20** de daño por ataque.
- Debe derrotar a **3 enemigos** seguidos, con **40, 60 y 80** puntos de vida y un daño de entre **5 y 15**.
- Dispone de **3 pociones** por partida; cada una cura **25** puntos sin superar los 100.
- En cada turno se puede **atacar**, **usar una poción**, **ver el inventario** (no gasta turno) o **abandonar**. Tras un turno gastado, el enemigo (si sigue vivo) contraataca.
- Cada enemigo derrotado suma **100 puntos**.- La partida acaba con victoria, derrota (vida a 0) o abandono. La puntuación se anota en el ranking.
## Ranking
 
- Se guarda en **`datos/ranking.xml`** y se carga al iniciar el programa.
- Guarda como máximo **10 registros**, ordenados de mayor a menor puntuación. En caso de empate, aparece primero el más antiguo.
- Si el fichero no existe, se empieza con un ranking vacío. Si existe pero está dañado o tiene datos no válidos, el programa **no lo sobrescribe**.
- La carpeta `datos/` debe existir en la raíz del proyecto.
## XML, XPath y XSLT
 
Todos los comandos se ejecutan desde la raíz del proyecto.
 
**Validar el XML con la DTD** (sin salida = válido):
 
```bash
xmllint --noout --valid datos/ranking.xml
```
 
**Consultas XPath** (las cinco están en [`datos/xpath_test.txt`](datos/xpath_test.txt)). Ejemplo:
 
```bash
xmllint --xpath 'count(/ranking/registro[puntos = 200])' datos/ranking.xml
```
 
**Generar la página HTML del ranking** (ordenada por puntos de mayor a menor):
 
```bash
xsltproc -o datos/ranking.html datos/ranking.xsl datos/ranking.xml
```
 
Después abre `datos/ranking.html` en el navegador. El fichero `ranking.css` debe estar en la misma carpeta, porque el HTML lo enlaza con una ruta relativa. Cada vez que cambie el ranking hay que repetir el comando para actualizar la página.
