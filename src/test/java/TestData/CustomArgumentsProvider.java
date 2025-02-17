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

        return Stream.of(
                Arguments.of(new Cargo(2, false, false), LOW_WORKLOAD, 400),
                Arguments.of(new Cargo(7, false, true), LOW_WORKLOAD, 500),
                Arguments.of(new Cargo(2, false, false), NORMAL_WORKLOAD, 400),
                Arguments.of(new Cargo(7, false, true), NORMAL_WORKLOAD, 600),
                Arguments.of(new Cargo(2, false, false), HIGH_WORKLOAD, 400),
                Arguments.of(new Cargo(7, false, true), HIGH_WORKLOAD, 700),
                Arguments.of(new Cargo(2, false, false), VERY_HIGH_WORKLOAD, 400),
                Arguments.of(new Cargo(7, false, true), VERY_HIGH_WORKLOAD, 800)
        );
    }
}
