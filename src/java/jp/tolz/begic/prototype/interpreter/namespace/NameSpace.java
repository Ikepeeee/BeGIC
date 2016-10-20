package jp.tolz.begic.prototype.interpreter.namespace;

import java.util.HashMap;

import jp.tolz.begic.prototype.interpreter.values.base.IBValue;

/**
 * �R�}���h����ѕϐ��̖��O���Ǘ����܂��B
 * �����񂩂�R�}���h����ѕϐ����Ăяo���܂��B
 * @author Toru Ikeda
 *
 */
public class NameSpace {
	private HashMap<String, IBValue> values = new HashMap<String, IBValue>();
	
	public boolean hasName(String identifier){
		return values.containsKey(identifier);
	}
	
	public IBValue getValue(String identifier){
		return values.get(identifier);
	}
	
	public void register(String identifier){
		values.put(identifier, null);
	}
	
	public void setValue(String identifier, IBValue value){
		values.put(identifier, value);
	}
	
}
