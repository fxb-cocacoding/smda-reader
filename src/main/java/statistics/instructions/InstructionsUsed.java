package statistics.instructions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class InstructionsUsed {
	private SMDA smda;
	private List<String> instructionsUsed = new ArrayList<String>();
	
	/*
	 * ToDo: Stick it into the fabric
	 */
	public InstructionsUsed(SMDA smda) {
		this.smda = smda;
	}
	
	/*
	 * Iterate through all instruction blocks.
	 * Add all new instructions to the list, skip the ones we already have.
	 * This results in a unique list of instructions.
	 * 
	 */
	
	public void countInstructions() {
		List<String> tmpTables = new ArrayList<String>();
		for(Function f : smda.getXcfg().getFunctions()) {
			for(Block blocks : f.getBlocks()) {
				for(Instruction inst : blocks.getInstructions()) {
					String opcode = inst.getMnemonics().toArray()[0].toString();
					if(!tmpTables.contains(opcode)) {
						tmpTables.add(opcode);
					}
				}
			}
		}
        Collections.sort(tmpTables);
        assert(instructionsUsed.isEmpty());
        instructionsUsed.addAll(tmpTables);
	}
	
	public int getNumberOfUniqueInstructions() {
		return instructionsUsed.size();
	}
	
	public String toString() {
		assert(instructionsUsed != null);
		return instructionsUsed.toString();
	}
	
	public String toNiceString() {
		assert(instructionsUsed != null);
		StringBuilder sb = new StringBuilder();
		sb.append("instructions: ");
		for(String i : instructionsUsed) {
			sb.append(i);
			sb.append(' ');
		}
		// Remove the last element, ' ' from loop above
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		sb.append("instructions used: ");
		sb.append(instructionsUsed.size());
		return sb.toString();
	}
}