package smtx_handler;

import java.io.Serializable;

public class HeaderSummary implements Serializable {
	/*
	 * Example of a summary:
	 */
	
	/*
	
	 "summary": {
	  "num_api_calls": 1142,
	  "num_basic_blocks": 10242,
	  "num_disassembly_errors": 58,
	  "num_function_calls": 3777,
	  "num_functions": 844,
	  "num_instructions": 51216,
	  "num_leaf_functions": 105,
	  "num_recursive_functions": 7
 	},


	*/

	private static final long serialVersionUID = 358546885617036383L;
	private long num_api_calls;
	private long num_basic_blocks;
	private long num_disassembly_errors;
	private long num_function_calls;
	private long num_functions;
	private long num_instructions;
	private long num_leaf_functions;
	private long num_recursive_functions;

	
	public long getNum_api_calls() {
		return num_api_calls;
	}
	
	public void setNum_api_calls(long num_api_calls) {
		this.num_api_calls = num_api_calls;
	}
	
	public long getNum_basic_blocks() {
		return num_basic_blocks;
	}
	
	public void setNum_basic_blocks(long num_basic_blocks) {
		this.num_basic_blocks = num_basic_blocks;
	}
	
	public long getNum_disassembly_errors() {
		return num_disassembly_errors;
	}
	
	public void setNum_disassembly_errors(long num_disassembly_errors) {
		this.num_disassembly_errors = num_disassembly_errors;
	}
	
	public long getNum_function_calls() {
		return num_function_calls;
	}
	
	public void setNum_function_calls(long num_function_calls) {
		this.num_function_calls = num_function_calls;
	}
	
	public long getNum_functions() {
		return num_functions;
	}
	
	public void setNum_functions(long num_functions) {
		this.num_functions = num_functions;
	}
	
	public long getNum_instructions() {
		return num_instructions;
	}
	
	public void setNum_instructions(long num_instructions) {
		this.num_instructions = num_instructions;
	}
	
	public long getNum_leaf_functions() {
		return num_leaf_functions;
	}
	
	public void setNum_leaf_functions(long num_leaf_functions) {
		this.num_leaf_functions = num_leaf_functions;
	}
	
	public long getNum_recursive_functions() {
		return num_recursive_functions;
	}
	
	public void setNum_recursive_functions(long num_recursive_functions) {
		this.num_recursive_functions = num_recursive_functions;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HeaderSummary [num_api_calls=" + num_api_calls + ", num_basic_blocks=" + num_basic_blocks
				+ ", num_disassembly_errors=" + num_disassembly_errors + ", num_function_calls=" + num_function_calls
				+ ", num_functions=" + num_functions + ", num_instructions=" + num_instructions
				+ ", num_leaf_functions=" + num_leaf_functions + ", num_recursive_functions=" + num_recursive_functions
				+ "]";
	}
	
	
}
