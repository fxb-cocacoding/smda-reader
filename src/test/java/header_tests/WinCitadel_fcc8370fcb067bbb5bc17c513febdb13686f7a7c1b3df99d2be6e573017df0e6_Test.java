package header_tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import header_tests.TestingTemplates;
import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.SMDA;

public class WinCitadel_fcc8370fcb067bbb5bc17c513febdb13686f7a7c1b3df99d2be6e573017df0e6_Test {
	
	/*
	 * HeaderSummary [	  "num_api_calls": 1172,
						  "num_basic_blocks": 10690,
						  "num_disassembly_errors": 69,
						  "num_function_calls": 3972,
						  "num_functions": 876,
						  "num_instructions": 53430,
						  "num_leaf_functions": 115,
						  "num_recursive_functions": 7
						]
	 */
	
	final static String filename = "src/test/resources/smda_samples/win.citadel/fcc8370fcb067bbb5bc17c513febdb13686f7a7c1b3df99d2be6e573017df0e6_dump_0x02390000.smda";
	final static long	  num_api_calls = 1172,
						  num_basic_blocks = 10690,
						  num_disassembly_errors = 69,
						  num_function_calls = 3972,
						  num_functions = 876,
						  num_instructions = 53430,
						  num_leaf_functions = 115,
						  num_recursive_functions = 7;

	
	SMDA smda = null;
	long all = 0;
	
	@Before  
	public void init() throws Exception {
		try {
			smda = TestingTemplates.testSummary(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCitadelNumApiCalls() {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getApirefs().size();
		}
		assertEquals(num_api_calls, smda.getSummary().getNum_api_calls());
		assertEquals(num_api_calls, all);
	}
	
	@Test
	public void testCitadelNumBasicBlocks()  {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getBlocks().size();
		}
		assertEquals(num_basic_blocks, smda.getSummary().getNum_basic_blocks());
		assertEquals(num_basic_blocks, all);
	}
	
	@Test
	public void testCitadelNumFunctionCalls() {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getInrefs().size();
		}
		assertEquals(num_function_calls, smda.getSummary().getNum_function_calls());
		assertEquals(num_function_calls, all);
	}
	
	@Test
	public void testCitadelNumFunctions() {
		all = smda.getXcfg().getFunctions().size();
		assertEquals(num_functions, smda.getXcfg().getFunctions().size());
		assertEquals(num_functions, all);
	}
	
	@Test
	public void testCitadelNumInstructions() {
		all = 0;
		for(Function f : smda.getXcfg().getFunctions()) {
			for(Block blocks : f.getBlocks()) {
				all += blocks.getInstructions().size();
			}
		}
		assertEquals(num_instructions, smda.getSummary().getNum_instructions());
		assertEquals(num_instructions, all);
	}
}
