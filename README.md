<h1 align="center" style="font-weight: bold;">Rubrica Telefonica 💻</h1>

<p align="center">
  <a href="#tech">Tecnologie</a>
  <a href="#collab">Membri</a>
  <a href="#docs">Documentazione</a>
</p>

<p align="center">Semplice rubrica telefonica realizzata in Java, che consente la gestione di contatti (nome, cognome, numero di telefoni e indirizzi e-mail), attraverso un'interfaccia grafica (GUI) realizzata in JavaFX.</p>

<h2 id="tech">💻 Tecnologie usate e dipendenze software</h2>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=javafx&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Doxygen](https://img.shields.io/badge/doxygen-2C4AA8?style=for-the-badge&logo=doxygen&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-f5f5f5?style=for-the-badge&logo=junit5&logoColor=dc524a)

L'applicazione é stata scritta in Java e necessita della JVM per l'esecuzione e di una jdk-23 installata. É stata testata con l'ultima jdk fornita direttamente da [Oracle](https://www.oracle.com/java/technologies/downloads/) ma non dovrebbero esserci problemi anche con le versioni alternative.

L'interfaccia grafica é stata realizzata in javaFX, mediante [Scene Builder](https://gluonhq.com/products/scene-builder/). Nonostante sia stata utilizzata la jdk-23, che non include piú al suo interno le librerie relative a javaFX, non é necessario installare il relativo SDK in quanto é presente uno script [Maven](https://maven.apache.org/) che si occupa automaticamente della gestione delle dipendenze. In tal caso é necessaria una connessione di rete affinché Maven possa scaricare le dipendenze dal relativo repository.
<h2 id="docs">📕 Documentazione</h2>

- [Documentazione Latex](docs/Documentazione.pdf) ufficiale del progetto
- [Documentazione Doxygen](https://emanueletocci.github.io/uni-swe-project/), disponibile anche al seguente [link](https://emanueletocci.github.io/uni-swe-project/) mediante github pages
- [Mockup GUI](https://www.figma.com/design/yRfKYzcJxZzwm7U6lgOw9i/Rubrica-Telefonica?node-id=5-8&t=NYnUuBUaWFlwxWm4-1) figma

### 🛠️ Guida al Building
Per prima cosa é necessario clonare il progetto in locale. Si puó usare il seguente comando da terminale o utilizzare un tool dotato di GUI come Github Desktop.

    git clone https://github.com/emanueletocci/uni-swe-project.git
    
All'interno della cartella appena scaricata sono presenti 2 sottocartelle:
- [docs](docs): contiene la documentazione (latex e doxygen) e i diagrammi UML del progetto
- [sources/Rubrica](sources): contiene il codice sorgente, il pom di maven e alcuni file di configurazione degli IDE. Il codice sorgente in particolar modo, si trova in `src/main`, secondo l'organizzazione del codice imposta da Maven.

Per la compilazione é necessario raggiungere la directory `sources/Rubrica`. Dalla radice `uni-swe-project` si puó usare il seguente comando da terminale:
    
    cd sources/Rubrica
    
A questo punto é possibile:
- Compilare tutti i sorgenti: `mvn compile`
- Eseguire gli unit test: `mvn test`
- Cancellare i file prodotti dalle precedenti compilazioni: `mvn clean`
- Eseguire l'applicazione: `mvn javafx:run`

Nella directory `src/main/resources/files` é presente il file `Noi.vcf` precompilato, che puó essere importato nella rubrica per testarne le funzionalitá. La validitá del file puó essere testata mediante un [tool online](https://freefileviewers.com/) oppure semplicemente importandolo in un software simile, compatibile con lo standard vCard, come per esempio l'app "Rubrica" dello smartphone o del computer.

Se non si vuole seguire l'approccio da riga di comando é comunque possibile importare il progetto (`sources/Rubrica`) in un IDE come IntelliJ o netbeans, caricando il file `pom.xml` fornito.

Qualora ci fosse qualche problema con lo script Maven (`pom.xml`) fornito, é comunque possibile compilare ed eseguire l'applicazione scaricando manualmente la SDK di javaFX e specificando il suo percorso, come spiegato nella [wiki ufficiale](https://openjfx.io/openjfx-docs/#install-javafx).

### ▶️ File .jar forniti
Nell'ultima release sono stati forniti 2 file .jar direttamente eseguibili, realizzati mediante il plugin `shade` di maven che consente di incorporare direttamente le dipendenze (javaFX) scaricate nel .jar. É presente una versione `aarch64` ed una versione `x86`, bisogna tuttavia tener presente che la compilazione é avvenuta in ambiente linux (x86) e macOS (aarch64) pertanto le dipendenze incorporate da `shade` potrebbero non essere completamente soddisfatte sugli altri sistemi operativi, dal momento che le dipendenze scaricate da Maven sono specifiche per quel determina SO.


<h2 id="collab">🧑‍🤝‍🧑 Gruppo07</h2>

- [Emanuele Tocci](https://github.com/emanueletocci)
- [Alessio Leo](https://github.com/Al3Leo)
- [Claudia Montefusco](https://github.com/ClaudiaMontefusco3)
- [Rossella Pale](https://github.com/rossellapale)

