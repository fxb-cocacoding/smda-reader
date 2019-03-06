package converters.ngrams;

import java.util.ArrayList;
import java.util.List;

import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class NgramGenerator {
		
	public List<Ngram> createWithoutOverlappingCodeCavesUsingFunctions(SMDA smda) {
		ArrayList<Ngram> allNgrams = new ArrayList<>();
		
		/*
		 * Currently unimplemented, use createWithoutOverlappingCodeCaves
		 */
		
		return allNgrams;
	}
	
	public List<Ngram> createWithoutOverlappingCodeCaves(List<List<Instruction>> linearizedDisassembly, int n) {
		ArrayList<Ngram> allNgrams = new ArrayList<>();
		
		for(List<Instruction> instructionList : linearizedDisassembly) {
			for(int i=0; i<instructionList.size(); i++) {
				
				if(i+n < instructionList.size()) {
					Ngram ngram = new Ngram(n);
					for(int j=i; j<i+n; j++) {
						ngram.ngramInstructions.add(instructionList.get(j));
					}
					allNgrams.add(ngram);
				}
			}
		}
		
		return allNgrams;
	}
	
	/*
	 * Currently unimplemented, since we never needed that, there is no real use-case for this.
	 */
	public List<Ngram> createWithOverlappingCodeCaves(List<List<Instruction>> linearizedDisassembly) {
		ArrayList<Ngram> allNgrams = new ArrayList<>();
		
		if(1==1) throw new UnsupportedOperationException();
		
		return allNgrams;
	}
}
