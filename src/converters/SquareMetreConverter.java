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
	
	@Override
	public String toStringBr() {
		return "Area - metro ao quadrado (m\\\\u33a1)";
	}
	
	@Override
	public String toStringNa() {
		return "Area - squared metre (m\\\\u33a1)";
	}
	
}
