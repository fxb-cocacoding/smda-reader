package smtx_handler;

import java.io.Serializable;

public class ApiRef implements Serializable {
	private static final long serialVersionUID = 6028813804011975877L;

	private long offset;
	private String apicall;
	
	
	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public String getApicall() {
		return apicall;
	}

	public void setApicall(String apicall) {
		this.apicall = apicall;
	}

	
	@Override
	public String toString() {
		return " ApiRef [offset=" + offset + ", apicall=" + apicall + "] ";
	}
}
