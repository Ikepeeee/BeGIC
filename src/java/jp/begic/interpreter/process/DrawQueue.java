package jp.begic.interpreter.process;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描写処理をキューとして格納します。
 * @author Toru Ikeda
 *
 * @param <E>
 */
public class DrawQueue<E> {
	ArrayBlockingQueue<E> a = new ArrayBlockingQueue<E>(1000);
	
}
