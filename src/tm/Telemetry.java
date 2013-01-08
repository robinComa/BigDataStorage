package tm;

public abstract class Telemetry {
	
	public static final long FRAME_TIME = 1000 * 24;
	
	private String o;
	private String l;
	private String d;
	
	public Telemetry(){

	}
	
	public Telemetry(String opscode, String date){
		this.o = opscode;
		this.l = opscode;
		this.d = date;
	}
	
	public String getO() {
		return o;
	}
	public void setO(String opscode) {
		this.o = opscode;
	}
	public String getL() {
		return l;
	}
	public void setL(String label) {
		this.l = label;
	}
	public String getD() {
		return d;
	}

	public void setD(String date) {
		this.d = date;
	}
	
}
