package jp.begic.interpreter.namespace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import jp.begic.interpreter.values.base.IBValue;

/**
 * �R�}���h����ѕϐ��̖��O���Ǘ����܂��B
 * �����񂩂�ϐ����Ăяo���܂��B
 * �܂��R�}���h�ƒl��1��1�Ή��ł��邱�Ƃ�ۏ؂��A�l�̃A�h���X���环�ʎq���Ăяo���܂��B
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
	
	/**
	 * �l���环�ʎq���擾���܂��B�l��IBValue::eq�ł͂Ȃ��AJava�̃A�h���X����v�����Ƃ��ł��B
	 * @param value
	 * @return �Y���̎��ʎq�̕�����B������Ȃ��ꍇ��null�B
	 */
	public String getIdentifer(IBValue value){
		for(String iden : values.keySet()){
			if(value == values.get(iden)){
				return iden;
			}
		}
		return null;
	}
	
	public void register(String identifier){
		values.put(identifier, null);
	}
	
	// optimize!!
	public void setValue(String identifier, IBValue value){
		if(values.containsValue(value))
			values.put(identifier, (IBValue) deepCopy(value));
		values.put(identifier, value);
	}
	
	private static Object deepCopy(Object o) {
		Object copy = null;

		try {
			// �I�u�W�F�N�g�𕄍������A�o�C�g�z��ɏ�������
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);

			// ���������ꂽ�I�u�W�F�N�g�̃f�[�^��ێ�����z����擾
			byte[] buff = baos.toByteArray();
			// �o�C�g�z�񂩂�A�I�u�W�F�N�g�𕡍���
			ByteArrayInputStream bais = new ByteArrayInputStream(buff);
			ObjectInputStream os = new ObjectInputStream(bais);
			copy = os.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return copy;

	}
	
}
