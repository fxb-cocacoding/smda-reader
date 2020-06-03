package smtx_handler;

import java.io.Serializable;
import java.util.List;

import org.checkerframework.checker.signedness.qual.Unsigned;

public class Instruction implements Serializable {
	/*
	 * This is the class containing one block of the json disassembly file
	 * Search the following elements for further information
	 */

	private static final long serialVersionUID = 8011492919947143599L;
	
	@Unsigned
	private long offset;
	
	private String opcodes;
	private List<String> mnemonics;

	
	/* Only opcodes are relevant for us*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opcodes == null) ? 0 : opcodes.hashCode());
		return result;
	}

	/* Only opcodes are relevant for us*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Instruction)) {
			return false;
		}
		Instruction other = (Instruction) obj;
		if (opcodes == null) {
			if (other.opcodes != null) {
				return false;
			}
		} else if (!opcodes.equals(other.opcodes)) {
			return false;
		}
		return true;
	}
	
	
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public String getOpcodes() {
		return opcodes;
	}
	public void setOpcodes(String opcodes) {
		this.opcodes = opcodes;
	}
	public List<String> getMnemonics() {
		return mnemonics;
	}
	public void setMnemonics(List<String> mnemonics) {
		this.mnemonics = mnemonics;
	}
	
	public int getAssemblySize() {
		return opcodes.length()/2;
	}
	
	
	/*
	 * real equals
	 * 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instruction other = (Instruction) obj;
		if (mnemonics == null) {
			if (other.mnemonics != null)
				return false;
		} else if (!mnemonics.equals(other.mnemonics))
			return false;
		if (offset != other.offset)
			return false;
		if (opcodes == null) {
			if (other.opcodes != null)
				return false;
		} else if (!opcodes.equals(other.opcodes))
			return false;
		return true;
	}
	*/
	
	
	
	@Override
	public String toString() {
		return "    Instruction [offset=" + Long.toUnsignedString(this.offset) + ", opcodes=" + opcodes + ", mnemonics=" + mnemonics + "]";
	}
	
	public String toStringInDisassemblyView() {
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toUnsignedString(this.offset));
		sb.append("    ");
		sb.append(this.opcodes);
		sb.append("    ");
		for(String s : mnemonics) {
			sb.append(s);
			sb.append("  ");
		}
		return sb.toString();
	}
	
}
