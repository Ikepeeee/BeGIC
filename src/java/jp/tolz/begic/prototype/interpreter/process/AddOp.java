package jp.tolz.begic.prototype.interpreter.process;

import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.base.BValue;

/**
 * â¡éZââéZÇÃèàóùÇçsÇ¢Ç‹Ç∑ÅB
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
			System.err.println("íËã`Ç≥ÇÍÇ»Ç¢ââéZÇ≈Ç∑ÅB");
		}
		return null;
	}

}
