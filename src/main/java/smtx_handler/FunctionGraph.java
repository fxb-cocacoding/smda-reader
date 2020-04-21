package smtx_handler;

import java.io.Serializable;
import java.util.List;

public class FunctionGraph implements Serializable {
	private static final long serialVersionUID = 3336559101514792535L;
	
	private List<Function> functions;
	
	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Function f : functions) {
			sb.append("Function: " + f.getBegin());
			sb.append("\n");
			sb.append(f.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}