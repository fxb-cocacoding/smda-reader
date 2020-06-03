package smtx_handler;

import java.util.List;
import java.util.Objects;

public class CodeAreas {
	private List<CodeArea> code_areas;

	public List<CodeArea> getCode_areas() {
		return code_areas;
	}

	public void setCode_areas(List<CodeArea> code_areas) {
		this.code_areas = code_areas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code_areas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CodeAreas)) {
			return false;
		}
		CodeAreas other = (CodeAreas) obj;
		return Objects.equals(code_areas, other.code_areas);
	}

	@Override
	public String toString() {
		return "CodeAreas [code_areas=" + code_areas + "]";
	}
	
	
}
