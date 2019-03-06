package statistics.instructions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class InstructionOccurrenceCounter {
	private SMDA smda;
	private Map<String, Long> instructionTuples = new LinkedHashMap<String, Long>();
	
	public SMDA getSmda() {
		return smda;
	}


	public void setSmda(SMDA smda) {
		this.smda = smda;
	}


	public Map<String, Long> getInstructionTuples() {
		return instructionTuples;
	}


	public void setInstructionTuples(Map<String, Long> instructionTuples) {
		this.instructionTuples = instructionTuples;
	}


	/*
	 * ToDo: Stick it into the fabric
	 */
	public InstructionOccurrenceCounter(SMDA smda) {
		this.smda = smda;
	}
	
	
	/*
	 * Iterate through all instruction blocks.
	 * If an entry is already in there, get the current counter value,
	 * increment it and store it back in the Map.
	 * 
	 * If the value is new, add a new key (opcode, e.g. mov,push,etc)
	 * and set the current value to one.
	 * 
	 * This is a Map containing basically a dictionary/2-tuple, detailed:
	 * List of Entries of this kind: (opcode : counts),
	 * for example List: <("mov", 3289734), ("push", 2570672), ...>
	 */
	
	public void countInstructionOccurence() {
		Map<String, Long> tmpTables = new HashMap<String, Long>();
		for(Function f : smda.getXcfg().getFunctions()) {
			for(Block blocks : f.getBlocks()) {
				for(Instruction inst : blocks.getInstructions()) {
					String opcode = inst.getMnemonics().toArray()[0].toString();
					if( tmpTables.containsKey(opcode) ) {
						long count = tmpTables.get(opcode);
						count++;
						tmpTables.put(opcode, count);
					} else {
						tmpTables.put(opcode, (long) 1);
					}
				}
			}
		}
        List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>();
        list.addAll(tmpTables.entrySet());
        list.sort(Entry.comparingByValue());
        Collections.reverse(list);
        assert(instructionTuples.isEmpty());
        
        for(Entry<String, Long> e : list) {
        	instructionTuples.put(e.getKey(), e.getValue());
        }
	}
	
	public String toString() {
		assert(instructionTuples != null);
		return instructionTuples.toString();
	}
	
	public String toNiceString() {
		assert(instructionTuples != null);
		StringBuilder sb = new StringBuilder();
		for (String opcode : instructionTuples.keySet()) {
			sb.append(opcode + " " + instructionTuples.get(opcode));
			sb.append(" " + (instructionTuples.get(opcode)/((double) smda.getSummary().getNum_instructions()))*100 + "%" );
			sb.append("\n");
		}
		return sb.toString();
	}
}
