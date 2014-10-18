package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

	@Test
    public void testMultipleNumberswithnewlines(){
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test
    public void testMultipleNumberswithnewlinesandcommas(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
	public void testMinusnumbers(){
		try{
			Calculator.add("-4,5,-7,2");
		}
		catch(RuntimeException prufa){
			assertEquals("Negatives not allowed: -4,-7,", prufa.getMessage());
		}
	}

	@Test
    public void isitbiggerthan1k(){
    	assertEquals(14, Calculator.add("1000\n10,4"));
    }

    @Test
	public void testanydelimiter(){
		assertEquals(20, Calculator.add("//[*][%]\n4*14%2"));
	}

}
