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
	
	@Override
	public String toStringBr() {
		return "Area - Decimentro ao quadrado (dm\u00b2)";
	}
	
	@Override
	public String toStringNa() {
		return "Area - Square Decimetre (dm\u00b2)";
	}

	
}
