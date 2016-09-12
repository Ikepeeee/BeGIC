package jp.tolz.begic.prototype.interpreter.namespace;

import java.util.HashMap;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

/**
 * �R�}���h����ѕϐ��̖��O���Ǘ����܂��B
 * �����񂩂�R�}���h����ѕϐ����Ăяo���܂��B
 * @author Toru Ikeda
 *
 */
public class NameSpace {
	private static HashMap<String, BValue> values = new HashMap<String, BValue>();
	
	public static boolean hasName(String identifier){
		return values.containsKey(identifier);
	}
	
	public static BValue getValue(String identifier){
		return values.get(identifier);
	}
	
	public static void register(String identifier){
		values.put(identifier, null);
	}
	
	public static void register(String identifier, BValue value){
		values.put(identifier, value);
	}
}
