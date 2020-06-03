package smtx_handler;

import java.io.Serializable;
import java.util.Objects;

public class Statistics implements Serializable {
	/*
	 * Example of a summary:
	 */
	
	/*
	
	 "statistics": {
	  "num_api_calls": 0,
	  "num_basic_blocks": 9254,
	  "num_failed_functions": 31,
	  "num_failed_instructions": 0,
	  "num_function_calls": 3411,
	  "num_functions": 786,
	  "num_instructions": 46346,
	  "num_leaf_functions": 105,
	  "num_recursive_functions": 6
	 },


	*/

	private static final long serialVersionUID = 358546885617036383L;
	private long num_api_calls;
	private long num_basic_blocks;
	private long num_failed_functions;
	private long num_failed_instructions;
	private long num_function_calls;
	private long num_functions;
	private long num_instructions;
	private long num_leaf_functions;
	private long num_recursive_functions;

	
	


	@Override
	public String toString() {
		return "HeaderSummary [num_api_calls=" + num_api_calls + ", num_basic_blocks=" + num_basic_blocks
				+ ", num_disassembly_failed_functions=" + num_failed_functions
				+ ", num_disassembly_failed_instructions=" + num_failed_instructions
				+ ", num_function_calls=" + num_function_calls + ", num_functions=" + num_functions
				+ ", num_instructions=" + num_instructions + ", num_leaf_functions=" + num_leaf_functions
				+ ", num_recursive_functions=" + num_recursive_functions + "]";
	}





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





	public long getNum_failed_functions() {
		return num_failed_functions;
	}





	public void setNum_failed_functions(long num_failed_functions) {
		this.num_failed_functions = num_failed_functions;
	}





	public long getNum_failed_instructions() {
		return num_failed_instructions;
	}





	public void setNum_failed_instructions(long num_failed_instructions) {
		this.num_failed_instructions = num_failed_instructions;
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
	public int hashCode() {
		return Objects.hash(num_api_calls, num_basic_blocks, num_failed_functions, num_failed_instructions,
				num_function_calls, num_functions, num_instructions, num_leaf_functions, num_recursive_functions);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Statistics)) {
			return false;
		}
		Statistics other = (Statistics) obj;
		return num_api_calls == other.num_api_calls && num_basic_blocks == other.num_basic_blocks
				&& num_failed_functions == other.num_failed_functions
				&& num_failed_instructions == other.num_failed_instructions
				&& num_function_calls == other.num_function_calls && num_functions == other.num_functions
				&& num_instructions == other.num_instructions && num_leaf_functions == other.num_leaf_functions
				&& num_recursive_functions == other.num_recursive_functions;
	}
	
	
}
