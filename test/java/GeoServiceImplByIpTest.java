import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeoServiceImplByIpTest {
    @DisplayName("Тест метода -> ByIp")
    @ParameterizedTest
    @ValueSource(strings = {"127.0.0.1", "172.0.32.11", "96.44.183.149"})

    public void TestByIp(String ipTest){
        GeoService geoServiceTest = new GeoServiceImpl();
        Location actualLocation = geoServiceTest.byIp(ipTest);
        if (ipTest.equals("127.0.0.1"))
            assertEquals(new Location(null, null, null, 0), actualLocation);
        if (ipTest.equals("172.0.32.11"))
            assertEquals(new Location("Moscow", Country.RUSSIA, "Lenina", 15), actualLocation);
        if (ipTest.equals("96.44.183.149"))
            assertEquals(new Location("New York", Country.USA, " 10th Avenue", 32), actualLocation);
        if (ipTest.startsWith("172.")){
            Location newMoscowLocation = new Location("Moscow", Country.RUSSIA, null, 0);
            assertEquals(newMoscowLocation.getCity(), actualLocation.getCity());
            assertEquals(newMoscowLocation.getCountry(), actualLocation.getCountry());
        }
        if (ipTest.startsWith("96.")){
            Location newNewYorkLocation = new Location("New York", Country.USA, null, 0);
            assertEquals(newNewYorkLocation.getCity(), actualLocation.getCity());
            assertEquals(newNewYorkLocation.getCountry(), actualLocation.getCountry());
        }

    }
}
