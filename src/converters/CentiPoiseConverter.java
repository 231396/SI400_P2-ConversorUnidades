package converters;

public class CentiPoiseConverter extends AbstractConverter{

	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VISCOSITY;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit / 1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 1000;
	}
	
	@Override
	public String toStringBr() {
		return "Viscosidade - centiPoise (cP)";
	}
	
	@Override
	public String toStringNa() {
		return "Viscosity - centiPoise (cP)";
	}
	
}
