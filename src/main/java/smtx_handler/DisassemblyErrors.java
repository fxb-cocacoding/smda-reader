package smtx_handler;

import java.util.List;
import java.util.Objects;

public class DisassemblyErrors {
	private List<DisassemblyError> disassembly_errors;

	public List<DisassemblyError> getDisassembly_errors() {
		return disassembly_errors;
	}

	public void setDisassembly_errors(List<DisassemblyError> disassembly_errors) {
		this.disassembly_errors = disassembly_errors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disassembly_errors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DisassemblyErrors)) {
			return false;
		}
		DisassemblyErrors other = (DisassemblyErrors) obj;
		return Objects.equals(disassembly_errors, other.disassembly_errors);
	}

	@Override
	public String toString() {
		return "DisassemblyErrors [disassembly_errors=" + disassembly_errors + "]";
	}
	
	
}
