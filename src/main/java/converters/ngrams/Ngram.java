package converters.ngrams;

import java.util.ArrayList;
import java.util.List;

import smtx_handler.Instruction;

public class Ngram {
	
	public int n;
	public int score;
	
	public Ngram(int n) {
		this.n = n;
	}
	
	List<Instruction> ngramInstructions = new ArrayList<>();
	
	public List<Instruction> getNgramInstructions() {
		return ngramInstructions;
	}

	public void setNgramInstructions(List<Instruction> ngramInstructions) {
		this.ngramInstructions = ngramInstructions;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ngrams<" + n + "|" + score + ">: ");
		for(int i=0; i<ngramInstructions.size(); i++) {
			sb.append(ngramInstructions.get(i) + " ");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n;
		result = prime * result + ((ngramInstructions == null) ? 0 : ngramInstructions.hashCode());
		return result;
	}

	
	/*
	 * Missing score parameter.
	 * not a real equals method but okay for us
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ngram other = (Ngram) obj;
		if (n != other.n)
			return false;
		if (ngramInstructions == null) {
			if (other.ngramInstructions != null)
				return false;
		} else if (!ngramInstructions.equals(other.ngramInstructions))
			return false;
		return true;
	}
	
	
}
