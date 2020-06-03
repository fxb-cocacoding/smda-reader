package smtx_handler;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(apicall, offset);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ApiRef)) {
			return false;
		}
		ApiRef other = (ApiRef) obj;
		return Objects.equals(apicall, other.apicall) && offset == other.offset;
	}
}
