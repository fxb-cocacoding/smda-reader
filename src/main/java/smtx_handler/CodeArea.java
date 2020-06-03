package smtx_handler;

import java.util.Objects;

public class CodeArea {

	private long start_section;
	private long end_section;
	
	
	public long getStart_section() {
		return start_section;
	}
	public void setStart_section(long start_section) {
		this.start_section = start_section;
	}
	public long getEnd_section() {
		return end_section;
	}
	public void setEnd_section(long end_section) {
		this.end_section = end_section;
	}
	@Override
	public int hashCode() {
		return Objects.hash(end_section, start_section);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CodeArea)) {
			return false;
		}
		CodeArea other = (CodeArea) obj;
		return end_section == other.end_section && start_section == other.start_section;
	}
	
	
	@Override
	public String toString() {
		return "CodeArea [start_section=" + start_section + ", end_section=" + end_section + "]";
	}
	
	
	
}
