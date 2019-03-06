package converters;

import java.util.List;

import converters.linearization.Linearization;
import converters.ngrams.Ngram;
import converters.ngrams.NgramGenerator;
import smtx_handler.Instruction;
import smtx_handler.SMDA;

public class ConverterFactory {

	public List<List<Instruction>> getLinearized(SMDA smda) {
		return new Linearization(smda).linearize();
	}
	
	public List<Ngram> calculateNgrams(String mode, List<List<Instruction>> linearizedDisassembly, int n) {
		if(mode.equalsIgnoreCase("createWithoutOverlappingCodeCaves")) {
			return new NgramGenerator().createWithoutOverlappingCodeCaves(linearizedDisassembly, n);
		} else if (false) {
			
		} else {
			throw new java.lang.UnsupportedOperationException();
			
		}
		return null;
	}

}
