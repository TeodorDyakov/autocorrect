package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import suggester.Keyboard;

public class KeyboardTest {

	@Test
	public void test1() {
		List<Character> expected = new ArrayList<>();
		expected.add('e');
		expected.add('c');
		expected.add('s');
		expected.add('f');
		assertEquals(expected, Keyboard.getClosestKeys('d'));
	}

	@Test
	public void test2() {
		List<Character> expected = new ArrayList<>();
		expected.add('q');
		expected.add('z');
		expected.add('s');
		assertEquals(expected, Keyboard.getClosestKeys('a'));
	}

	@Test
	public void test3() {
		List<Character> expected = new ArrayList<>();
		expected.add('q');
		expected.add('2');
		assertEquals(expected, Keyboard.getClosestKeys('1'));
	}

	@Test
	public void test4() {
		List<Character> expected = new ArrayList<>();
		expected.add(']');
		expected.add('\'');
		assertEquals(expected, Keyboard.getClosestKeys('\\'));
	}

	@Test
	public void test5() {
		List<Character> expected = new ArrayList<>();
		expected.add(';');
		expected.add('.');
		assertEquals(expected, Keyboard.getClosestKeys('/'));
	}

}
