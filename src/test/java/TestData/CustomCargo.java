package TestData;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.korobovs.Cargo;

import java.util.stream.Stream;

public class CustomCargo implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return Stream.of(
                Arguments.of(new Cargo(2, true, true), 550),
                Arguments.of(new Cargo(2, false, false), 150),
                Arguments.of(new Cargo(7, false, true), 500),
                Arguments.of(new Cargo(7, true, false), 300),
                Arguments.of(new Cargo(21, true, true), 700),
                Arguments.of(new Cargo(21, false, false), 300),
                Arguments.of(new Cargo(31, true, false), 500)
        );
    }
}
