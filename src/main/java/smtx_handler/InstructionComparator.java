package smtx_handler;

import java.util.Comparator;

public class InstructionComparator implements Comparator<Instruction> {
	public int compare(Instruction self, Instruction comparedWith) {
		Long currentOffset = self.getOffset();
		Long otherInstruction = comparedWith.getOffset();
		return ((int) (currentOffset - otherInstruction));
	}
}
