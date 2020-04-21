package converters.ngrams;

import java.util.ArrayList;
import java.util.List;

import smtx_handler.Instruction;

public class Ngram {
	
	public int n;
	public int score;
	private String concat;
	public long lowerAddressLimit = 0;
	public long higherAddressLimit = 0;
	
	
	public Ngram(int n) {
		this.n = n;
	}
	
	List<Instruction> ngramInstructions = new ArrayList<>();
	
	public List<Instruction> getNgramInstructions() {
		return ngramInstructions;
	}

	public void setNgramInstructions(List<Instruction> ngramInstructions) {
		this.ngramInstructions = ngramInstructions;
		if(ngramInstructions != null) {
			for(Instruction ins : ngramInstructions) {
				concat = concat + ins.getOpcodes();
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ngrams<" + n + "|" + score + "|" + lowerAddressLimit + "/" + higherAddressLimit + ">: ");
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ngram)) {
			return false;
		}
		Ngram other = (Ngram) obj;
		if (n != other.n) {
			return false;
		}
		if (ngramInstructions == null) {
			if (other.ngramInstructions != null) {
				return false;
			}
		} else if (!ngramInstructions.equals(other.ngramInstructions)) {
			return false;
		}
		return true;
	}

	public String getOpcodes() {
		StringBuilder ret = new StringBuilder();
		for(Instruction i: ngramInstructions) {
			ret.append(i.getOpcodes());
		}
		return ret.toString();
	}

	public List<String> getOpcodesList() {
		List<String> ret = new ArrayList<String>();
		for(Instruction i: ngramInstructions) {
			ret.add(i.getOpcodes());
		}
		return ret;
	}
	

	public boolean isOverlapping(Ngram other) {
		int nextCounter = 0;
		final int limit = (other.n / 2) + 1;
		
		List<String> thisOpcodesList = this.getOpcodesList();
		List<String> otherOpcodesList = other.getOpcodesList();
		
		for(int i=0; i<otherOpcodesList.size(); i++) {
			for(int j=0; j<thisOpcodesList.size(); j++) {
				
				// We detected that the current string is equal:
				if(otherOpcodesList.get(i).equals(thisOpcodesList.get(j))) {
					for(int k=0; k<limit; k++) {
						if(i + k < otherOpcodesList.size() && j + k < thisOpcodesList.size()) {
							if(otherOpcodesList.get(i+k).equals(thisOpcodesList.get(j+k))) {
								nextCounter++;
							} else {
								nextCounter = 0;
							}
							// To check against a possible corner case:
							if(nextCounter == limit) {
								return true;
							}
						} else {
							// We ran into the limit.
							return false;
						}
					}
				}
			}
		}
		
		if(nextCounter == limit) {
			return true;
		}
		
		return false;
	}

	//TODO: Implementation is not good since it is possible that the 
	public int getOverlappingFactor(Ngram other) {
		int ret = 0;
		
		if(other.n > this.n) {
			for(String s: other.getOpcodesList()) {
				if(this.getOpcodesList().contains(s)) {
					ret++;
				}
			}
		} else {
			for(String s: this.getOpcodesList()) {
				if(other.getOpcodesList().contains(s)) {
					ret++;
				}
			}
		}
		
		return ret;
	}
}
