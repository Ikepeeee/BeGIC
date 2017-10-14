package jp.begic.interpreter.values.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BDecimal;
import jp.begic.interpreter.values.BString;
import jp.begic.interpreter.values.BValue;

import org.junit.Test;

public class BStringTest {

	@Test
	public void testType() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testBString() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testToString() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testAnd() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testOr() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testNot() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testEq() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testGe() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testNeq() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testLe() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testGt() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testLt() {
		fail("�܂���������Ă��܂���");
	}

	@Test
	public void testAdd() {
		BString a = new BString("abc");
		BString b = new BString("def");
		try {
			assertEquals(a.add(b).getValue(), "abcdef");
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			fail("�G���[�ɂȂ�܂��B");
		}
	}

	@Test
	public void testSub() {
		BString a = new BString("abcabc");
		BString b = new BString("a");
		try {
			assertEquals("bcbc", a.sub(b).getValue());
		} catch (BegicRunTimeException e) {
			fail("�G���[�ɂȂ�܂��B");
		}
	}

	@Test
	public void testMul() {
		BString a = new BString("abc");
		BDecimal n = new BDecimal(4);
		try {
			assertEquals("abcabcabcabc", a.mul(n).getValue());
		} catch (BegicRunTimeException e) {
			fail("�G���[�ɂȂ�܂��B");
		}
	}

	@Test
	public void testDiv() {
		BString a = new BString("abc");
		BString b = new BString("a");
		try {
			a.mul(b).getValue();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("�G���[�ɂȂ�Ȃ��B");
	}

	@Test
	public void testMod() {
		BString a = new BString("abc");
		BString b = new BString("a");
		try {
			a.mul(b).getValue();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("�G���[�ɂȂ�Ȃ��B");
	}

	@Test
	public void testPow() {
		BString a = new BString("abc");
		BString b = new BString("a");
		try {
			a.mul(b).getValue();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("�G���[�ɂȂ�Ȃ��B");
	}

	@Test
	public void testAbs() {
		BString a = new BString("abc");
		try {
			a.abs();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("�G���[�ɂȂ�Ȃ��B");
	}

	@Test
	public void testAdditiveIdentity() {
		BString a = new BString("abc");
		try {
			a.additiveIdentity();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("�G���[�ɂȂ�Ȃ��B");
	}

}
