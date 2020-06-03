package smtx_handler;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Block implements Serializable {

	private static final long serialVersionUID = -1498343007148560270L;
	private List<Instruction> instructions;
	private String blockOffset;
	
	
	public String getBlockOffset() {
		return blockOffset;
	}
	public void setBlockOffset(String blockOffset) {
		this.blockOffset = blockOffset;
	}
	public List<Instruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "    Block [instructions=    " + instructions.toString() + "    blockOffset=" + blockOffset + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(blockOffset, instructions);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Block)) {
			return false;
		}
		Block other = (Block) obj;
		return Objects.equals(blockOffset, other.blockOffset) && Objects.equals(instructions, other.instructions);
	}
	
	
}
