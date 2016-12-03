package jp.tolz.begic.prototype.interpreter.process;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * •`Êˆ—‚ğƒLƒ…[‚Æ‚µ‚ÄŠi”[‚µ‚Ü‚·B
 * @author Toru Ikeda
 *
 * @param <E>
 */
public class DrawQueue<E> {
	ArrayBlockingQueue<E> a = new ArrayBlockingQueue<E>(1000);
	
}
