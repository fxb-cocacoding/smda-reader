package converters.linearization;

import java.util.ArrayList;
import java.util.List;

import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class BlockCandidateIdentifier {
	/*
	 * Here is the engine implemented which can detect possible candidates for the glue stick.
	 * Handles a smda object structure, to generate linearized assembly
	 */
	
	private List<Instruction> tmp = null;
	private List<List<Instruction>> orderedInstructionList = null;
	
	protected BlockCandidateIdentifier(SMDA smda) {
		this.generateInstructionList(smda);
		this.identifyAndGlueFollowingInstructions();
	}
	
	
	private void generateInstructionList(SMDA smda) {
		
		assert(tmp == null);
		if(smda.getXcfg() == null) {
			return;
		}
		/*
		 * First: It flatens your input into the linear list of all instructions.
		 * You loose some of the overhead information laying in the cfg, but this is not needed for our 
		 */
		
		tmp = new ArrayList<>();
		
		for(Function f : smda.getXcfg().getFunctions()) {
			for (Block b : f.getBlocks()) {
				for(Instruction i : b.getInstructions()) {
					tmp.add(i);
				}
			}
		}
	}
	
	protected List<List<Instruction>> getOrderedInstructionList() {
		assert(orderedInstructionList != null);
		return orderedInstructionList;
	}
	
	private void identifyAndGlueFollowingInstructions() {
		orderedInstructionList = new ArrayList<>();
		orderedInstructionList.add(new ArrayList<>());
		
		assert(tmp != null);
		if(tmp == null) return;
		
		int noChainCounter = 0;
		boolean hasNext = true;
		
		for(int i = 0;i<tmp.size();i++) {
			
			if(tmp.get(i) == null) return;
			
			long currentOffset = tmp.get(i).getOffset();
			//System.out.println("current offset: " + currentOffset);
			
			long currentSize = tmp.get(i).getAssemblySize();
			//System.out.println("current size:   " + currentSize);
			
			long nextOffset = 0;
			
			if(i + 1 < tmp.size()) {
				nextOffset = tmp.get(i + 1).getOffset();
				//System.out.println("next offset:    " + nextOffset);
				hasNext = true;
			} else {
				hasNext = false;
			}
			if(nextOffset - currentOffset == currentSize) {
				//System.out.println("a real chain");
				orderedInstructionList.get(noChainCounter).add(tmp.get(i));
			} else {
				//System.err.println("NO CHAIN!!");
				if(hasNext) {
					orderedInstructionList.add(new ArrayList<>());
					noChainCounter++;
				}
			}
		}		
	}
}
