import TestData.CustomArgumentsProvider;
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

    @Step("Функция расстояния")
    @DisplayName("Проверяем оплату на разные расстояния")
    @Tag("distance")
    @ParameterizedTest
    @CsvFileSource(resources = "different_distance.csv", useHeadersInDisplayName = true)
    public void testGetCostDistance(int distance, int summa) {

        int result = Calculation.getCostDistance(distance);

        Assertions.assertEquals(summa, result);
    }

    @Step("Функция размер")
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

    @Step("Функция хрупкость")
    @DisplayName("Проверяем оплату за хрупкий товар")
    @Tags({@Tag("fragile"), @Tag("distance")})
    @ParameterizedTest
    @CsvFileSource(resources = "fragile_distance.csv", useHeadersInDisplayName = true)
    public void testGetCostFragile(boolean fragile, int distance, int summa) {

        int result = Calculation.getCostFragile(fragile, distance);

        Assertions.assertEquals(summa, result);
    }

    @Step("Функция калькулято")
    @DisplayName("Проверяем оплату за загруженность склада")
    @Tags({@Tag("workload"), @Tag("fragile"), @Tag("distance"), @Tag("isBig")})
    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    public void testCalculation(Cargo cargo, double workload, int summa) {
        double result = Calculation.calculation(cargo, workload);

        Assertions.assertEquals(summa * 1.0, result);
    }
}
