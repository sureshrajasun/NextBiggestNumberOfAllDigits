import com.workout.app.NextBiggestNumberOfADigit;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestNextBiggestNumberOfADigit {

    private static NextBiggestNumberOfADigit nextBiggestNumberOfADigit;

    @BeforeClass
    public static void setUpFixture() {
        nextBiggestNumberOfADigit = new NextBiggestNumberOfADigit();
    }

    @Test
    public void noBiggestNumber() {
        assertEquals("9876", nextBiggestNumberOfADigit.getNextBigNumber("9876"));
        assertEquals("76543", nextBiggestNumberOfADigit.getNextBigNumber("76543"));
    }
    @Test
    public void nextBiggestNumber() {
        assertEquals("12354", nextBiggestNumberOfADigit.getNextBigNumber("12345"));
        assertEquals("45687654323456765432123434556", nextBiggestNumberOfADigit.getNextBigNumber("45687654323456765432123456543"));
        assertEquals("6543243", nextBiggestNumberOfADigit.getNextBigNumber("6543234"));
    }

}
