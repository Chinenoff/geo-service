import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"RUSSIA", "USA"})
    @DisplayName("Тест метода -> locale")

    public void testValidCounty(Country testCountry) {
        LocalizationService testLocalizationServiceImpl = new LocalizationServiceImpl();

        String actualCountry = testLocalizationServiceImpl.locale(testCountry);

        assertNotNull(actualCountry);
        if (testCountry.equals(Country.RUSSIA))
            assertEquals("Добро пожаловать", actualCountry);
        if (testCountry.equals(Country.USA))
            assertEquals("Welcome", actualCountry);
    }
}
