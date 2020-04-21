package linearization_tester;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import converters.linearization.Linearization;
import converters.ngrams.Ngram;
import converters.ngrams.NgramGenerator;
import header_tests.TestingTemplates;
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
	public void getLinearizedOutput() {
		Linearization l = new Linearization(smda);
		l.linearize();
		
		int counter_n_4 = 0;
		int counter_n_5 = 0;
		int counter_n_6 = 0;
		int counter_n_7 = 0;
		
		NgramGenerator n = new NgramGenerator();

		
		List<Ngram> ngrams4 = n.createWithoutOverlappingCodeCaves(l, 4);
		
		for(Ngram ngram: ngrams4) {
			assertTrue(ngram.getNgramInstructions().size() == 4);

			switch(ngram.n) {
				case 4:
					counter_n_4++;
					break;
	
				case 5:
					counter_n_5++;
					break;
	
				case 6:
					counter_n_6++;
					break;
	
				case 7:
					counter_n_7++;
					break;
			}
		}
		List<Ngram> ngrams5 = n.createWithoutOverlappingCodeCaves(l, 5);
		
		for(Ngram ngram: ngrams5) {
			assertTrue(ngram.getNgramInstructions().size() == 5);
			switch(ngram.n) {
				case 4:
					counter_n_4++;
					break;
	
				case 5:
					counter_n_5++;
					break;
	
				case 6:
					counter_n_6++;
					break;
	
				case 7:
					counter_n_7++;
					break;
			}
		}
		List<Ngram> ngrams6 = n.createWithoutOverlappingCodeCaves(l, 6);
		
		for(Ngram ngram: ngrams6) {
			assertTrue(ngram.getNgramInstructions().size() == 6);
			switch(ngram.n) {
				case 4:
					counter_n_4++;
					break;
	
				case 5:
					counter_n_5++;
					break;
	
				case 6:
					counter_n_6++;
					break;
	
				case 7:
					counter_n_7++;
					break;
			}
		}
		List<Ngram> ngrams7 = n.createWithoutOverlappingCodeCaves(l, 7);
		
		for(Ngram ngram: ngrams7) {
			assertTrue(ngram.getNgramInstructions().size() == 7);
			switch(ngram.n) {
				case 4:
					counter_n_4++;
					break;
	
				case 5:
					counter_n_5++;
					break;
	
				case 6:
					counter_n_6++;
					break;
	
				case 7:
					counter_n_7++;
					break;
			}
		}

		
		System.out.println("4: " + counter_n_4);
		System.out.println("5: " + counter_n_5);
		System.out.println("6: " + counter_n_6);
		System.out.println("7: " + counter_n_7);
		
	}
}
