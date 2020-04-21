package converters;

import java.util.List;

import converters.linearization.Linearization;
import converters.ngrams.Ngram;
import converters.ngrams.NgramGenerator;
import smtx_handler.SMDA;

public class ConverterFactory {

	public Linearization getLinearized(SMDA smda) {
		Linearization l = new Linearization(smda);
		l.linearize();
		return l;
	}
	
	public List<Ngram> calculateNgrams(String mode, Linearization linearizedDisassembly, int n) {
		if(mode.equalsIgnoreCase("createWithoutOverlappingCodeCaves")) {
			return new NgramGenerator().createWithoutOverlappingCodeCaves(linearizedDisassembly, n);
		} else {
			throw new java.lang.UnsupportedOperationException();
		}
	}

}
