package smtx_handler;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(offset, refs);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BlockRef)) {
			return false;
		}
		BlockRef other = (BlockRef) obj;
		return offset == other.offset && Objects.equals(refs, other.refs);
	}
	
	
}
