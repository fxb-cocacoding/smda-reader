package header_tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import header_tests.TestingTemplates;
import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.SMDA;

public class WinCitadel_0e967868c1f693097857d6d1069a3efca1e50f4516bb2637a10761d9bf4992ff_Test {
	
	/*
	 * HeaderSummary [	num_api_calls=1141, 
						num_basic_blocks=10242,
						num_disassembly_errors=58,
						num_function_calls=3777,
						num_functions=844,
						num_instructions=51216,
						num_leaf_functions=105,
						num_recursive_functions=7	]
	 */
	
	final static String filename = "src/test/resources/smda_samples/win.citadel/0e967868c1f693097857d6d1069a3efca1e50f4516bb2637a10761d9bf4992ff_dump_0x02390000.smda";
	final static long	num_api_calls=0, 
			  			num_basic_blocks=10229,
			  			num_disassembly_failed_functions=42,
			  			num_disassembly_failed_instructions=0,
			  			num_function_calls=3780,
			  			num_functions=845,
			  			num_instructions=51088,
			  			num_leaf_functions=110,
			  			num_recursive_functions=7;
	
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
