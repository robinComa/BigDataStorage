package tm;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;

import com.sun.jersey.api.json.JSONWithPadding;

@Path("/{opscode}")
@Produces("application/javascript")
public class TelemetryResource {
	
	private String opscode;
	private String callback;
	
	public TelemetryResource(@PathParam("opscode") String opscode, @QueryParam("callback") String callback){
		this.opscode = opscode;
		this.callback = callback;
	}
	
	@GET
	@Path("/{min}/{max}")
	public JSONWithPadding  getTms(@PathParam("min") long min, @PathParam("max") Long max, @QueryParam("attr") String attr) {
		List<PlotTelemetry> tms = new ArrayList<PlotTelemetry>();
		int nb = (int) ((max - min) / Telemetry.FRAME_TIME);
		for(int i = 0 ; i < nb ; i++){
			PlotTelemetry t = new PlotTelemetry("IH9RCTA9", String.valueOf(min + i * Telemetry.FRAME_TIME));
			/** Current time == min + getD() in second -> less characters in JSONp file */
			t.setD(String.valueOf((Long.parseLong(t.getD()) - min) / 1000));
			if(attr != null){
				t.attributeFilter(attr);
			}
			tms.add(t);
		}
		return new JSONWithPadding( new GenericEntity<List<PlotTelemetry>>(tms) {}, this.callback);
	}
	
}
