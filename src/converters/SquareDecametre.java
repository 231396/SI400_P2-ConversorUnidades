package converters;

public class SquareDecametre extends AbstractConverter {
	
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

	public String toString() {
		return "Distance - Square Decametre (dam\\\\u33a1)";
	}


}
