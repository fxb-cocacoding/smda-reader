package smtx_handler;

public class Meta {
	private double binweight;
	private String component;
	
	private String family;
	private String filename;
	
	private boolean is_library;
	private String version;
	
	
	public double getBinweight() {
		return binweight;
	}
	public void setBinweight(double binweight) {
		this.binweight = binweight;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public boolean isIs_library() {
		return is_library;
	}
	public void setIs_library(boolean is_library) {
		this.is_library = is_library;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(binweight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + (is_library ? 1231 : 1237);
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Meta)) {
			return false;
		}
		Meta other = (Meta) obj;
		if (Double.doubleToLongBits(binweight) != Double.doubleToLongBits(other.binweight)) {
			return false;
		}
		if (component == null) {
			if (other.component != null) {
				return false;
			}
		} else if (!component.equals(other.component)) {
			return false;
		}
		if (family == null) {
			if (other.family != null) {
				return false;
			}
		} else if (!family.equals(other.family)) {
			return false;
		}
		if (filename == null) {
			if (other.filename != null) {
				return false;
			}
		} else if (!filename.equals(other.filename)) {
			return false;
		}
		if (is_library != other.is_library) {
			return false;
		}
		if (version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!version.equals(other.version)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Meta [binweight=" + binweight + ", component=" + component + ", family=" + family + ", filename="
				+ filename + ", is_library=" + is_library + ", version=" + version + "]";
	}
	
	

}
