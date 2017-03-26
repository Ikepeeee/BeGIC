package jp.begic.interpreter.values.base;

import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BValue;

public interface IBCollection {
	public BValue push(BValue key, BValue value) throws BegicRunTimeException;
	public BValue unshift(BValue key, BValue value) throws BegicRunTimeException;
	public BValue pop() throws BegicRunTimeException;
	public BValue shift() throws BegicRunTimeException;
	public BValue last() throws BegicRunTimeException;
	public BValue first() throws BegicRunTimeException;
	public BValue get(BValue key) throws BegicRunTimeException;
	public BValue set(BValue key, BValue value) throws BegicRunTimeException;
	public BValue size() throws BegicRunTimeException;
}
