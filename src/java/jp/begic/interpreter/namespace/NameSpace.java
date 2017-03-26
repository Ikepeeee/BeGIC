package jp.begic.interpreter.namespace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import jp.begic.interpreter.values.base.IBValue;

/**
 * コマンドおよび変数の名前を管理します。
 * 文字列から変数を呼び出せます。
 * またコマンドと値が1対1対応であることを保証し、値のアドレスから識別子を呼び出せます。
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
	 * 値から識別子を取得します。値はIBValue::eqではなく、Javaのアドレスが一致したときです。
	 * @param value
	 * @return 該当の識別子の文字列。見つからない場合はnull。
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
			// オブジェクトを符号化し、バイト配列に書き込み
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);

			// 符号化されたオブジェクトのデータを保持する配列を取得
			byte[] buff = baos.toByteArray();
			// バイト配列から、オブジェクトを複合化
			ByteArrayInputStream bais = new ByteArrayInputStream(buff);
			ObjectInputStream os = new ObjectInputStream(bais);
			copy = os.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return copy;

	}
	
}
