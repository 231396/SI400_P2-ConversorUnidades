package converters;

public class GramConverter extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.MASS;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*1000;
	}
	
	@Override
	public String toStringBr() {
		return "Distancia - Grama (g)";
	}
	
	@Override
	public String toStringNa() {
		return "Mass - Gram (g)";
	}



}
