import it.unisa.diem.swe.group07.rubrica.gestoreIO.Export;
import it.unisa.diem.swe.group07.rubrica.gestoreIO.Import;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author gruppo 07
 */
public class ImportTest {

    private Rubrica rubrica;
    private Import importer;
    private ObservableList<ContattoEsteso> list;
    String path;

    @BeforeEach
    public void setUp() {
        rubrica = new Rubrica();
        importer = new Import();
        list = FXCollections.observableArrayList();
        path = "src/test/resources/";
    }

    @Test
    public void testImportVcard() throws IOException {
        // Crea un contatto di test
        ContattoEsteso contatto = new ContattoEsteso(
                "Rossella",
                "Pale",
                "+3933333333",
                "+3933333333",
                "+3933333333",
                "prova@gmail.com",
                "prova@gmail.com",
                "prova@gmail.com",
                LocalDate.of(2003, 4, 24),
                "Fisciano",
                "github.com",
                "studentessa",
                true,
                true
        );

        Export exporter = new Export();
        exporter.esportaContatto(contatto, path + "provaImport");
        String filePath = path + "provaImport.vcf";//importa provaImport.vcf
        importer.importVcard(rubrica, list, filePath);

        assertEquals(1, rubrica.getContatti().size());
        assertTrue(rubrica.getContatti().contains(contatto));

        assertEquals(1, list.size());
        assertTrue(list.contains(contatto));

        Files.delete(Path.of(filePath));
    }
}
