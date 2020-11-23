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
		return "Area - Metro ao quadrado (m\u00b2)";
	}
	
	@Override
	public String toStringNa() {
		return "Area - Squared metre (m\u00b2)";
	}
	
}
