package converters.linearization;

import java.util.List;

import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class Linearization {
	/*
	 * Main class for the linearization process.
	 * Here we combine everything.
	 */
	
	private SMDA sortedSMDA;
	
	public Linearization(SMDA smda) {
		this.sortedSMDA = smda;
	}
	
	public List<List<Instruction>> linearize() {
		sortedSMDA.sort();
		BlockCandidateIdentifier ident = new BlockCandidateIdentifier(this.sortedSMDA);
		return ident.getOrderedInstructionList();
	}
	
}
