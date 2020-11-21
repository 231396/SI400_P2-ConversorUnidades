package converters;

public class PoiseuilleConverter extends AbstractConverter{

	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VISCOSITY;
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
		return "Viscosidade - Poiseuille (Pa s)";
	}
	
	@Override
	public String toStringNa() {
		return "Viscosity - Poiseuille(Pa s)";
	}
	
}
