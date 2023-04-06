package utils;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomAssertion {
    public static <T> void assertThatAllListElements(List<T> listOfElement, Predicate<T> predicate) {
        assertThat(listOfElement.stream().filter(predicate).toList().size()).isEqualTo(listOfElement.size());
    }
}
