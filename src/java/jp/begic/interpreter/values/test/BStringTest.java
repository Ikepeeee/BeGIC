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
		fail("まだ実装されていません");
	}

	@Test
	public void testBString() {
		fail("まだ実装されていません");
	}

	@Test
	public void testToString() {
		fail("まだ実装されていません");
	}

	@Test
	public void testAnd() {
		fail("まだ実装されていません");
	}

	@Test
	public void testOr() {
		fail("まだ実装されていません");
	}

	@Test
	public void testNot() {
		fail("まだ実装されていません");
	}

	@Test
	public void testEq() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGe() {
		fail("まだ実装されていません");
	}

	@Test
	public void testNeq() {
		fail("まだ実装されていません");
	}

	@Test
	public void testLe() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGt() {
		fail("まだ実装されていません");
	}

	@Test
	public void testLt() {
		fail("まだ実装されていません");
	}

	@Test
	public void testAdd() {
		BString a = new BString("abc");
		BString b = new BString("def");
		try {
			assertEquals(a.add(b).getValue(), "abcdef");
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			fail("エラーになります。");
		}
	}

	@Test
	public void testSub() {
		BString a = new BString("abcabc");
		BString b = new BString("a");
		try {
			assertEquals("bcbc", a.sub(b).getValue());
		} catch (BegicRunTimeException e) {
			fail("エラーになります。");
		}
	}

	@Test
	public void testMul() {
		BString a = new BString("abc");
		BDecimal n = new BDecimal(4);
		try {
			assertEquals("abcabcabcabc", a.mul(n).getValue());
		} catch (BegicRunTimeException e) {
			fail("エラーになります。");
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
		fail("エラーにならない。");
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
		fail("エラーにならない。");
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
		fail("エラーにならない。");
	}

	@Test
	public void testAbs() {
		BString a = new BString("abc");
		try {
			a.abs();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("エラーにならない。");
	}

	@Test
	public void testAdditiveIdentity() {
		BString a = new BString("abc");
		try {
			a.additiveIdentity();
		} catch (BegicRunTimeException e) {
			return;
		}
		fail("エラーにならない。");
	}

}
