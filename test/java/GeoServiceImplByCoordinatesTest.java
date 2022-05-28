import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceImplByCoordinatesTest {
    @Test
    @DisplayName("Тест метода -> byCoordinates")
    public void testCreateTempFile() throws RuntimeException {
        double latitude = 0.1;
        double longitude = 0.1;
        GeoService geoServiceTest = new GeoServiceImpl();

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            geoServiceTest.byCoordinates(latitude, longitude);
        });
        assertNotNull(thrown.getMessage());
    }
}
