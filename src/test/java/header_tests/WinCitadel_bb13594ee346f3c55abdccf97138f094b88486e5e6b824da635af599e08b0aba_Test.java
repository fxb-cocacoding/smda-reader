package header_tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import smtx_handler.Block;
import smtx_handler.Function;
import smtx_handler.Meta;
import smtx_handler.SMDA;

public class WinCitadel_bb13594ee346f3c55abdccf97138f094b88486e5e6b824da635af599e08b0aba_Test {
	
	/*
	 * HeaderSummary [	num_api_calls=1184, 
	 * 					num_basic_blocks=13719,
	 * 					num_disassembly_errors=29,
	 * 					num_function_calls=5345,
	 * 					num_functions=999,
	 * 					num_instructions=65361,
	 * 					num_leaf_functions=139,
	 * 					num_recursive_functions=10	]
	 */
	
	final static String filename = "src/test/resources/smda_samples/win.citadel/bb13594ee346f3c55abdccf97138f094b88486e5e6b824da635af599e08b0aba_dump_0x00140000.smda";
	final static long num_api_calls = 0,
					  num_basic_blocks = 13551,
					  num_disassembly_failed_functions = 31,
					  num_disassembly_failed_instructions = 0,
					  num_function_calls = 5306,
					  num_functions = 1006,
					  num_instructions = 64826,
					  num_leaf_functions = 147,
					  num_recursive_functions = 9;


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
	public void testMetaData() {
		Meta meta = smda.getMetadata();
		assertEquals("win.citadel", meta.getFamily());
		assertEquals("bb13594ee346f3c55abdccf97138f094b88486e5e6b824da635af599e08b0aba_dump_0x00140000", meta.getFilename());
	}
	
	@Test
	public void testCitadelNumApiCalls() {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getApirefs().size();
		}
		assertEquals(num_api_calls, smda.getStatistics().getNum_api_calls());
		assertEquals(num_api_calls, all);
	}
	
	@Test
	public void testCitadelNumBasicBlocks()  {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getBlocks().size();
		}
		assertEquals(num_basic_blocks, smda.getStatistics().getNum_basic_blocks());
		assertEquals(num_basic_blocks, all);
	}
	
	@Test
	public void testCitadelNumFunctionCalls() {
		all = 0;
		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getInrefs().size();
		}
		assertEquals(num_function_calls, smda.getStatistics().getNum_function_calls());
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
		assertEquals(num_instructions, smda.getStatistics().getNum_instructions());
		assertEquals(num_instructions, all);
	}
}