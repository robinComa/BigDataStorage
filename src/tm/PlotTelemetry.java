package tm;

import java.util.Calendar;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;
import bigdata.BigDataNetwork;

@XmlRootElement
public class PlotTelemetry extends Telemetry implements BigDataNetwork{

	private float v;
	
	public PlotTelemetry(){
		super();
	}
	
	public PlotTelemetry(String opscode, String date){
		super(opscode, date);
		Random r = new Random();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(date));
		double alea = Math.sin(c.get(Calendar.DAY_OF_YEAR)) * 10 + (c.get(Calendar.YEAR) % 100 + 365 / c.get(Calendar.DAY_OF_YEAR));
		if(alea > 100){
			alea = 100 + alea % 100 / 100;
		}
		this.v = (float) (20 + r.nextFloat() * (150 - 20) + alea);
	}

	public float getV() {
		return v;
	}

	public void setV(float value) {
		this.v = value;
	}

	@Override
	public void attributeFilter(String attr) {
		if(!attr.contains("o")){
			this.setO(null);
		}
		if(!attr.contains("l")){
			this.setL(null);
		}
		if(!attr.contains("d")){
			this.setD(null);
		}
		if(!attr.contains("v")){
			this.setV(0.0F);
		}
	}
	
}
