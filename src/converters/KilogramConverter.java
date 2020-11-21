package converters;

public class KilogramConverter extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.MASS;
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
		return "Massa - Quilograma (kg)";
	}
	
	@Override
	public String toStringNa() {
		return "Mass - Kilogram (kg)";
	}

	

}
