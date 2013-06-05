package StringCalculator.Qsoft_Calculator4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCalculator {
	@Test
	public void testEmptyString(){
		Calculator cal = new Calculator();
		assertEquals(0,cal.add(""));
	}
	@Test
	public void testAddNumber(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("1,2,3"));
	}
	@Test
	public void testAddNewLine(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("1\n2,3"));
	}
	@Test
	public void testAddDelimiters(){
		Calculator cal = new Calculator();
		try {
			assertEquals(6,cal.add("//;\n1;2;3"));
			assertEquals(0,cal.add("//;\n1;2;-3"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	public void testThrowException(){
		Calculator cal = new Calculator();
		try {
			assertEquals(0,cal.add("//;\n1;2;-3"));
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed", e.getMessage());
		}		
	}
	@Test
	public void testBigger1000(){
		Calculator cal = new Calculator();
		assertEquals(2,cal.add("2,1001"));
	}
	@Test
	public void testDelimiter(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//[***]\n1***2***3"));
	}
	@Test
	public void testMultiDelimiters(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//[*][%]\n1*2%3"));
		
	}
}
