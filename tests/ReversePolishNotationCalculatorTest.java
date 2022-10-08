import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReversePolishNotationCalculatorTest {
    ReversePolishNotationCalculator sut = new ReversePolishNotationCalculator(); // System Under Test

    @Test
    public void shouldNotCalculateBlankString() {

        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> sut.calculatePolishNotation(""));
        Assertions.assertNull(ex.getMessage());
    }

    @Test
    public void shouldCalculate23plus() {
        int res = sut.calculatePolishNotation("2 3 +");
        Assertions.assertEquals(5, res);
    }

    @Test
    public void shouldCalculateMinus23Plus() {
        int res = sut.calculatePolishNotation("-2 3 +");
        Assertions.assertEquals(1, res);
    }

    @Test
    public void shouldCalculate23Minus() {
        int res = sut.calculatePolishNotation("2 3 -");
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void shouldCalculateMinus23Minus4PlusMultiply() {
        int res = sut.calculatePolishNotation("-2 3 -4 + *");
        Assertions.assertEquals(2, res);
    }
}


