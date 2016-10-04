package jp.tolz.begic.prototype.interpreter.process;

import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.BValue;

/**
 * ���Z���Z�̏������s���܂��B
 * 
 * @author Toru Ikeda
 *
 */
class AddOp {
	public static BValue eval(BValue val1, BValue val2) {
		if (val1.type() == BValue.BFLOAT && val2.type() == BValue.BFLOAT) {
			return new BFloat(Double.valueOf(val1.toString())
					+ Double.valueOf(val2.toString()));
		} else if (val1.type() == BValue.BSTRING
				&& val2.type() == BValue.BSTRING) {
			return new BString(val1.toString().concat(val2.toString()));

		} else if (val1.type() == BValue.BSTRING
				&& val2.type() == BValue.BFLOAT) {
			return new BString(val1.toString().concat(val2.toString()));

		} else if (val1.type() == BValue.BFLOAT
				&& val2.type() == BValue.BSTRING) {
			return new BString(val1.toString().concat(val2.toString()));

		} else if (val1.type() == BValue.BLIST && val2.type() == BValue.BLIST) {
			
			
		} else if (val1.type() == BValue.BHASH && val2.type() == BValue.BHASH) {

		} else {
			System.err.println("��`����Ȃ����Z�ł��B");
		}
		return null;
	}
	
	/**
	 * �P�����Z�q�̂Ƃ��̏������s���܂��B
	 * @param val
	 * @return
	 */
	public static BValue eval(BValue val){
		if(val.type() == BValue.BFLOAT){
			return val;
		}else{
			System.err.println("��`����Ȃ����Z�ł��B");
		}
		return null;
	}

}
