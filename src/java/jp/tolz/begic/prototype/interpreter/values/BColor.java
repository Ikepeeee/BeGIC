package jp.tolz.begic.prototype.interpreter.values;

import java.awt.Color;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;

public class BColor extends BValue<Color> {
	private Integer amount = null;
	private static final BColor WHITE = new BColor("white");

	public BColor(int r, int g, int b) {
		setValue(new Color(r, g, b));
	}

	public BColor(String color) {
		// 初期の量を1とする。
		amount = 1;

		switch (color) {
		case "red":
			setValue(Color.RED);
			break;
		case "blue":
			setValue(Color.BLUE);
			break;
		case "yellow":
			setValue(Color.YELLOW);
			break;
		case "green":
			setValue(Color.GREEN);
			break;
		case "black":
			setValue(Color.BLACK);
			break;
		case "white":
			setValue(Color.WHITE);
			break;
		default:
			int r = Integer.parseUnsignedInt(color.substring(1, 3), 16);
			int g = Integer.parseUnsignedInt(color.substring(2, 4), 16);
			int b = Integer.parseUnsignedInt(color.substring(4, 6), 16);
			setValue(new Color(r, g, b));
			break;
		}
	}

	@Override
	public int type() {
		return BCOLOR;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue eq(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		switch (other.type()) {
		case BCOLOR:
			double rate = ((double) this.amount)
					/ (this.amount + ((BColor) other).amount);
			int r = (int) (rate * ((double) this.value.getRed()) + ((1.0 - rate) * (double) ((BColor) other).value
					.getRed()));
			int g = this.value.getGreen() + ((BColor) other).value.getGreen();
			int b = this.value.getBlue() + ((BColor) other).value.getBlue();
			return new BColor(r, g, b);
		default:
			throw new BegicRunTimeException();
		}
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		if (other.type() != BCOLOR)
			throw new BegicRunTimeException();
		int r = this.value.getRed() - ((BColor) other).value.getRed();
		int g = this.value.getGreen() - ((BColor) other).value.getGreen();
		int b = this.value.getBlue() - ((BColor) other).value.getBlue();
		return new BColor(r, g, b);
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		if (other.type() != BCOLOR)
			throw new BegicRunTimeException();

		int r = this.value.getRed() * ((BColor) other).value.getRed();
		int g = this.value.getGreen() * ((BColor) other).value.getGreen();
		int b = this.value.getBlue() * ((BColor) other).value.getBlue();
		return new BColor(r, g, b);
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		if (other.type() != BCOLOR)
			throw new BegicRunTimeException();

		int r = this.value.getRed() / ((BColor) other).value.getRed();
		int g = this.value.getGreen() / ((BColor) other).value.getGreen();
		int b = this.value.getBlue() / ((BColor) other).value.getBlue();
		return new BColor(r, g, b);
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue abs() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		return WHITE;
	}
	
}
