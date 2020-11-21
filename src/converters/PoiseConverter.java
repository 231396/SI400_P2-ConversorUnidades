package converters;

public class PoiseConverter extends AbstractConverter{

	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VISCOSITY;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit / 10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 10;
	}
	
	@Override
	public String toStringBr() {
		return "Viscosidade - Poise (P)";
	}
	
	@Override
	public String toStringNa() {
		return "Viscosity - Poise (P)";
	}
	
}
