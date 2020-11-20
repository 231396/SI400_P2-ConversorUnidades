package converters;

public class InchConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
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
		return "Distancia - UnidadeDeMedia (abreviacao)";
	}

}
