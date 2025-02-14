package TestData;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.korobovs.Cargo;

import java.util.stream.Stream;

import static ru.korobovs.Workload.*;
import static ru.korobovs.Workload.VERY_HIGH_WORKLOAD;

public class CustomArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Cargo cargo = new Cargo(2, false, false);

        return Stream.of(
                Arguments.of(cargo, LOW_WORKLOAD, 550),
                Arguments.of(cargo, NORMAL_WORKLOAD, 580),
                Arguments.of(cargo, HIGH_WORKLOAD, 610),
                Arguments.of(cargo, VERY_HIGH_WORKLOAD, 640)
        );
    }
}
