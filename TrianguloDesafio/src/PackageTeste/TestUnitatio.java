package PackageTeste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Classes.WriteTxt;

public class TestUnitatio {

	@Test
	public void arquivo_txt_test01() throws IOException {
		WriteTxt writeTxt = new WriteTxt();
		float resultado = writeTxt.ReturnText("C:/Nova pasta/test01.txt");
		System.out.println(resultado);
		assertEquals(10.0, resultado);
		
	}
	
	@Test
	public void arquivo_txt_test02() throws IOException {
		WriteTxt writeTxt = new WriteTxt();
		float resultado = writeTxt.ReturnText("C:/Nova pasta/test02.txt");
		System.out.println(resultado);
		assertEquals(142.0, resultado);
		
	}
	
	@Test
	public void arquivo_txt_test03() throws IOException {
		WriteTxt writeTxt = new WriteTxt();
		float resultado = writeTxt.ReturnText("C:/Nova pasta/test03.txt");
		System.out.println(resultado);
		assertEquals(14.6, resultado);
	}
	
	@Test
	public void arquivo_txt_test04() throws IOException {
		WriteTxt writeTxt = new WriteTxt();
		float resultado = writeTxt.ReturnText("C:/Nova pasta/test04.txt");
		System.out.println(resultado);
		assertEquals(1.1, resultado);
		
	}
	
	@Test
	public void arquivo_txt_test05() throws IOException {
		WriteTxt writeTxt = new WriteTxt();
		float resultado = writeTxt.ReturnText("C:/Nova pasta/test05.txt");
		System.out.println(resultado);
		assertEquals(84169, resultado);
		
	}

}
