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
	private List<List<Instruction>> linearization;
	
	public Linearization(SMDA smda) {
		this.sortedSMDA = smda;
	}
	
	public void linearize() {
		sortedSMDA.sort();
		BlockCandidateIdentifier ident = new BlockCandidateIdentifier(this.sortedSMDA);
		linearization = ident.getOrderedInstructionList();
	}

	public List<List<Instruction>> getLinearization() {
		return linearization;
	}

	public void setLinearization(List<List<Instruction>> linearization) {
		this.linearization = linearization;
	}
	
	public SMDA getSortedSMDA() {
		return sortedSMDA;
	}

	public void setSortedSMDA(SMDA sortedSMDA) {
		this.sortedSMDA = sortedSMDA;
	}

}