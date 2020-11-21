package converters;

public class HectogramConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.MASS;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*10;
	}
	
	@Override
	public String toStringBr() {
		return "Massa - Hectograma (hg)";
	}
	
	@Override
	public String toStringNa() {
		return "Mass - Hectogram (hg)";
	}


}
