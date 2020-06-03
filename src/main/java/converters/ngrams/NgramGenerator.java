package converters.ngrams;

import java.util.ArrayList;
import java.util.List;

import converters.linearization.Linearization;
import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class NgramGenerator {
		
	public List<Ngram> createWithoutOverlappingCodeCavesUsingFunctions(SMDA smda) {
		//ArrayList<Ngram> allNgrams = new ArrayList<>();
		
		/*
		 * Currently unimplemented, use createWithoutOverlappingCodeCaves
		 */
		
		throw new UnsupportedOperationException();
		
		//return allNgrams;
	}
	
	public List<Ngram> createWithoutOverlappingCodeCaves(Linearization linearizedDisassembly, int n) {
		ArrayList<Ngram> allNgrams = new ArrayList<>(linearizedDisassembly.getLinearization().size());
		long begin = linearizedDisassembly.getSortedSMDA().getBase_addr();
		//old workaround, remove when verified.
		//if(begin < 0x100000) {
		//	begin = begin + 0x100000;
		//}
		long end = begin + linearizedDisassembly.getSortedSMDA().getBinary_size();
		
		for(List<Instruction> instructionList : linearizedDisassembly.getLinearization()) {
			
			for(int i=0; i<instructionList.size(); i++) {
				
				if(i+n < instructionList.size()) {
					Ngram ngram = new Ngram(n);
					ngram.lowerAddressLimit = begin;
					ngram.higherAddressLimit = end;
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
		//ArrayList<Ngram> allNgrams = new ArrayList<>();
		
		throw new UnsupportedOperationException();
		
		//return allNgrams;
	}
}
