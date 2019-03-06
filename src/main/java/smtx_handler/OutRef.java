package smtx_handler;

import java.io.Serializable;
import java.util.List;

public class OutRef implements Serializable {
	private static final long serialVersionUID = -8560126218146916553L;
	
	private String outrefOffset;
	private List<Long> outref;
	
	public String getOutrefOffset() {
		return outrefOffset;
	}
	public void setOutrefOffset(String outrefOffset) {
		this.outrefOffset = outrefOffset;
	}
	public List<Long> getOutrefs() {
		return outref;
	}
	public void setOutrefs(List<Long> outref) {
		this.outref = outref;
	}
	
	@Override
	public String toString() {
		return "OutRef [outref_offset=" + outrefOffset + ", outref=" + outref + "]";
	}
}
