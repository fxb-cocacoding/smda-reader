package smtx_handler;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class BlockRef implements Serializable {
	private static final long serialVersionUID = -1625452319911624237L;
	
	private long offset;
	private List<Long> refs;
	
	
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public List<Long> getRefs() {
		return refs;
	}
	public void setRefs(List<Long> refs) {
		this.refs = refs;
	}
	
	@Override
	public String toString() {
		return " BlockRef [offset=" + offset + ", refs=" + refs + "] ";
	}
}
