package converters;

public class SquareMetreConverter extends AbstractConverter{

	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.AREA;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit;
	}

	public String toString() {
		return "Area - Square Decimetre (dm\\\\u33a1)";
	}


	
}
