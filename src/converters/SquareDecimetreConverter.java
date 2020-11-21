package converters;

public class SquareDecimetreConverter extends AbstractConverter{

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.AREA;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/100;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*100;
	}

	public String toString() {
		return "Area - Square Decimetre (dm\\\\u33a1)";
	}

	
}
