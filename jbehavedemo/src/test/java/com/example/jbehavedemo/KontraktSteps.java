package com.example.jbehavedemo;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.When;

public class KontraktSteps {
	Kontrakt kontrakt = new Kontrakt();
	
	@When("set cyfrokrad argument to $argument then it should return null")
	public void nullException(int argument){
		assertNull(kontrakt.cyfrokrad(argument));
	}
	@When("set cyfrokrad argument to $argument then it should contain number $result1 or $result2")
	public void assertContains(int argument, String result1, String result2){
		assertThat(kontrakt.cyfrokrad(argument).toString(), either(containsString(result1)).or(containsString(result2)));
	}
	@When("set cyfrokrad argument to $argument then argument's length should be $length")
	public void assertLength(int argument, int length){
		assertTrue(String.valueOf(kontrakt.cyfrokrad(argument)).length() == length);
	}
	// hultajchochla
	
	@When("set hultajchochla argument to $argument than it should return result $result")
	public void assertSwitchNumbers(int argument, int result) throws NieudanyPsikusException{
		assertEquals(new Integer(argument), kontrakt.hultajchochla(result));
	}
	@When("set hultajchochla argument to $argument then argument's length should be $length")
	public void assertSameLength(int argument, int length) throws NieudanyPsikusException{
		assertTrue(kontrakt.hultajchochla(2545).toString().length() == kontrakt.hultajchochla(2545).toString().length());
	}
	@When("set hultajchochla argument to $argument then it should contain number $result1, $result2, $result3")
	public void containsNumbers(int argument, String result1, String result2, String result3) throws NieudanyPsikusException{
		assertThat(kontrakt.hultajchochla(argument).toString(), anyOf(containsString(result1), containsString(result2), containsString(result3)));
	}
	// Nieksztaltek
	@When("set nieksztaltek argument to $argument than it should return ucnchanged number $argument")
	public void assertsNoChange(int argument){
		assertEquals(new Integer(argument), kontrakt.nieksztaltek(argument));
	}
	@When("set nieksztaltek change3to8Test argument to $argument then it should contain number $result")
	public void change3to8Test(int argument, String result){
		assertThat(kontrakt.nieksztaltek(argument).toString(),containsString(result));
	}
	@When("set nieksztaltek change7to1Test argument to $argument then it should contain number $result")
	public void change7to1Test(int argument, String result){
		assertTrue(new Integer(kontrakt.nieksztaltek(argument)).toString().contains(result));
	}
	@When("set nieksztaltek change6to9Test argument to $argument then it should contain number $result")
	public void change6to9Test(int argument, String result){
		assertTrue(new Integer(kontrakt.nieksztaltek(argument)).toString().contains(result));
	}
}
