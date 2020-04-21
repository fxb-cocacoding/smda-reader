package header_tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import header_tests.TestingTemplates;
import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.SMDA;

public class WinCitadel_d147e69bd47cd504ca555fcad15081ac5bd79b584794a93d5b250eb73d05b186_Test {
	
	/*
	 * HeaderSummary [	num_api_calls=1033, 
						num_basic_blocks=9240,
						num_disassembly_errors=34,
						num_function_calls=3411,
						num_functions=780,
						num_instructions=46305,
						num_leaf_functions=99,
						num_recursive_functions=6	]
	 */
	
	final static String filename = "src/test/resources/smda_samples/win.citadel/d147e69bd47cd504ca555fcad15081ac5bd79b584794a93d5b250eb73d05b186_dump_0x02390000.smda";
	final static long	num_api_calls = 0,
	  					num_basic_blocks = 9243,
	  					num_disassembly_failed_functions = 19,
	  					num_disassembly_failed_instructions = 0,
	  					num_function_calls = 3414,
	  					num_functions = 780,
	  					num_instructions = 46305,
	  					num_leaf_functions = 102,
	  					num_recursive_functions = 6;
	
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
