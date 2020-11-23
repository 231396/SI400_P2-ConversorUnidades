package converters;

public class SquareDecametreConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.AREA;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit*100;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit/100;
	}
	
	@Override
	public String toStringBr() {
		return "Area - Decamentro ao quadrado (dam\\\\\\\\u33a1)";
	}
	
	@Override
	public String toStringNa() {
		return "Area - Square Decametre (dam\\\\u33a1)";
	}


}
