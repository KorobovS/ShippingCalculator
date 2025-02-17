import TestData.CustomArgumentsProvider;
import TestData.CustomCargo;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.korobovs.Calculation;
import ru.korobovs.Cargo;

@Epic("Тестируем калькулятор")
public class CalculationUnitTest {

    @Step("Проверяем метод подсчета расстояния")
    @DisplayName("Проверяем оплату на разные расстояния")
    @Tag("distance")
    @ParameterizedTest
    @CsvFileSource(resources = "different_distance.csv", useHeadersInDisplayName = true)
    public void testGetCostDistance(int distance, int summa) {

        int result = Calculation.getCostDistance(distance);

        Assertions.assertEquals(summa, result);
    }

    @Step("Проверяем метод подсчета расстояния")
    @DisplayName("Проверяем оплату на разные расстояния")
    @Tags({@Tag("distance"), @Tag("negative")})
    @ParameterizedTest
    @CsvSource({"0", "-6"})
    public void testGetCostDistanceNegative(int distance) {

        Assertions.assertThrows(RuntimeException.class, () ->
                        Calculation.getCostDistance(distance),
                "Расстояние должно быть больше 0");
    }

    @Step("Проверяем метод подсчета размера")
    @DisplayName("Проверяем оплату за размер")
    @Tag("isBig")
    @ParameterizedTest
    @CsvSource({
            "true, 200",
            "false, 100"
    })
    public void testGetCostBig(boolean big, int summa) {

        int result = Calculation.getCostBig(big);

        Assertions.assertEquals(summa, result);
    }

    @Step("Проверяем метод подсчета хрупкости")
    @DisplayName("Проверяем оплату за хрупкий товар")
    @Tags({@Tag("fragile"), @Tag("distance")})
    @ParameterizedTest
    @CsvFileSource(resources = "fragile_distance.csv", useHeadersInDisplayName = true)
    public void testGetCostFragile(boolean fragile, int distance, int summa) {

        int result = Calculation.getCostFragile(fragile, distance);

        Assertions.assertEquals(summa, result);
    }

    @Step("Проверяем метод подсчета хрупкости")
    @DisplayName("Проверяем оплату за хрупкий товар")
    @Tags({@Tag("fragile"), @Tag("distance"), @Tag("negative")})
    @ParameterizedTest
    @CsvSource({
            "true, 31",
            "true, 45"
    })
    public void testGetCostFragileNegative(boolean fragile, int distance) {

        Assertions.assertThrows(RuntimeException.class, () ->
                        Calculation.getCostFragile(fragile, distance),
                "Хрупкие грузы нельзя возить на расстояние более 30 км");
    }

    @Step("Проверяем метод подсчета с учетом min цены")
    @DisplayName("Проверяем оплату с учетом min цены")
    @Tags({@Tag("fragile"), @Tag("distance"), @Tag("isBig")})
    @ParameterizedTest
    @ArgumentsSource(CustomCargo.class)
    public void testGetCostWithCriteria(Cargo cargo, int summa) {
        int result = Calculation.getCostWithCriteria(cargo);

        Assertions.assertEquals(summa, result);
    }

    @Step("Проверяем калькулятор с учетом загруженности")
    @DisplayName("Проверяем оплату за загруженность склада")
    @Tags({@Tag("workload"), @Tag("fragile"), @Tag("distance"), @Tag("isBig")})
    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    public void testCalculation(Cargo cargo, double workload, int summa) {
        double result = Calculation.calculation(cargo, workload);

        Assertions.assertEquals(summa * 1.0, result);
    }
}
