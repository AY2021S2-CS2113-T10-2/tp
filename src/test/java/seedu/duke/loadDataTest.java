package seedu.duke;
import control.FileIsEmptyException;
import control.loadData;

import entity.Canteen;
import entity.Facility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class loadDataTest {
    @TempDir
    public static Path testFolder;
    private static final String TEST_DATA_FOLDER = "test/storageFileTest";
    private static final String NON_EXISTANT_FILE_NAME = "ThisFileDoesNotExist.txt";

    @Test
    public void constructor_fileIsEmpty_exceptionThrown() throws Exception, FileIsEmptyException {
        loadData ld = new loadData();
        //assertThrows(FileIsEmptyException.class, () -> ld.load());
    }

    @Test
    public void load_validFormat() throws Exception, FileIsEmptyException {
        loadData ld = new loadData();
        ld.load();
        List<Facility> actualAb = ld.getCanteens();
        List<Facility> expectedAb = getTestCanteen();
        assertEquals(actualAb.get(0).toString(), expectedAb.get(0).toString());
    }



    private List<Facility> getTestCanteen() throws Exception {
        Canteen canteen = new Canteen();
        List<Facility> canteens = new ArrayList<>();
        canteen.setFacilityID("1");
        canteen.setName("canteen1");
        canteen.strToFacilityType("CANTEEN");
        canteen.setLocation("5.5", "6.6");
        canteens.add(canteen);
        return canteens;
    }
}
