package tm;


public class StatusTelemetry extends Telemetry {

	private String value;
	
	public StatusTelemetry(String opscode, String date){
		super(opscode, date);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
