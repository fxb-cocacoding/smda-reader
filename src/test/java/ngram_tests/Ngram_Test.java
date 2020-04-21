package ngram_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import converters.ngrams.Ngram;
import smtx_handler.Instruction;

public class Ngram_Test {
	
	/*
        $sequence_6 = { 8b74240c 57 8bf9 8b06 8bce 8b1f ff5004 }
            // n = 7, score = 300
            //   8b74240c             | mov                 esi, dword ptr [esp + 0xc]
            //   57                   | push                edi
            //   8bf9                 | mov                 edi, ecx
            //   8b06                 | mov                 eax, dword ptr [esi]
            //   8bce                 | mov                 ecx, esi
            //   8b1f                 | mov                 ebx, dword ptr [edi]
            //   ff5004               | call                dword ptr [eax + 4]

        $sequence_7 = { 8b74240c 57 8bf9 8b06 8bce 8b1f }
            // n = 6, score = 300
            //   8b74240c             | mov                 esi, dword ptr [esp + 0xc]
            //   57                   | push                edi
            //   8bf9                 | mov                 edi, ecx
            //   8b06                 | mov                 eax, dword ptr [esi]
            //   8bce                 | mov                 ecx, esi
            //   8b1f                 | mov                 ebx, dword ptr [edi]

        $sequence_8 = { 57 8bf9 8b06 8bce 8b1f ff5004 }
            // n = 6, score = 300
            //   57                   | push                edi
            //   8bf9                 | mov                 edi, ecx
            //   8b06                 | mov                 eax, dword ptr [esi]
            //   8bce                 | mov                 ecx, esi
            //   8b1f                 | mov                 ebx, dword ptr [edi]
            //   ff5004               | call                dword ptr [eax + 4]


	 */
	
	@Test
	public void testCitadelNumApiCalls() {
		
		Ngram ngram6 = new Ngram(7);
		ngram6.score = 300;
		String[] op6 = {"8b74240c", "57", "8bf9", "8b06", "8bce", "8b1f", "ff5004"};
		List<Instruction> ins6 = new ArrayList<Instruction>();
		for(int i=0; i<op6.length; i++) {
			Instruction ins = new Instruction();
			ins.setOpcodes(op6[i]);
			ins6.add(ins);
		}
		ngram6.setNgramInstructions(ins6);

		
		Ngram ngram7 = new Ngram(6);
		ngram7.score = 300;
		String[] op7 = {"8b74240c", "57", "8bf9", "8b06", "8bce", "8b1f"};
		List<Instruction> ins7 = new ArrayList<Instruction>();
		for(int i=0; i<op7.length; i++) {
			Instruction ins = new Instruction();
			ins.setOpcodes(op7[i]);
			ins7.add(ins);
		}
		ngram7.setNgramInstructions(ins7);

		
		Ngram ngram8 = new Ngram(6);
		ngram8.score = 300;
		String[] op8 = {"57", "8bf9", "8b06", "8bce", "8b1f", "ff5004"};
		List<Instruction> ins8 = new ArrayList<Instruction>();
		for(int i=0; i<op8.length; i++) {
			Instruction ins = new Instruction();
			ins.setOpcodes(op8[i]);
			ins8.add(ins);
		}		
		ngram8.setNgramInstructions(ins8);
		
		
		
		
		Ngram ngram9 = new Ngram(6);
		ngram9.score = 300;
		String[] op9 = {"90", "90", "8b06", "8bce", "8b1f", "ff5004"};
		List<Instruction> ins9 = new ArrayList<Instruction>();
		for(int i=0; i<op9.length; i++) {
			Instruction ins = new Instruction();
			ins.setOpcodes(op9[i]);
			ins9.add(ins);
		}		
		ngram9.setNgramInstructions(ins9);
		
		
		Ngram ngram10 = new Ngram(6);
		ngram10.score = 300;
		String[] op10 = {"90", "8bf9", "90", "8bce", "90", "ff5004"};
		List<Instruction> ins10 = new ArrayList<Instruction>();
		for(int i=0; i<op10.length; i++) {
			Instruction ins = new Instruction();
			ins.setOpcodes(op10[i]);
			ins10.add(ins);
		}		
		ngram10.setNgramInstructions(ins10);
		
		
		System.out.println(ngram6.toString());
		System.out.println(ngram7.toString());
		System.out.println(ngram8.toString());
		
		assertTrue(ngram6.isOverlapping(ngram7));
		assertTrue(ngram7.isOverlapping(ngram6));
		
		assertTrue(ngram6.isOverlapping(ngram8));
		assertTrue(ngram8.isOverlapping(ngram6));
		
		assertTrue(ngram7.isOverlapping(ngram8));
		assertTrue(ngram8.isOverlapping(ngram7));
		
		assertTrue(ngram9.isOverlapping(ngram8));
		assertTrue(ngram8.isOverlapping(ngram9));
		
		assertFalse(ngram8.isOverlapping(ngram10));
		assertFalse(ngram10.isOverlapping(ngram8));
		
		assertFalse(ngram9.isOverlapping(ngram10));
		assertFalse(ngram10.isOverlapping(ngram9));
		
		
		assertEquals(ngram6.getOverlappingFactor(ngram7), 6);
		assertEquals(ngram7.getOverlappingFactor(ngram6), 6);
		
		assertEquals(ngram6.getOverlappingFactor(ngram8), 6);
		assertEquals(ngram8.getOverlappingFactor(ngram6), 6);
		
		assertEquals(ngram8.getOverlappingFactor(ngram7), 5);
		assertEquals(ngram7.getOverlappingFactor(ngram8), 5);
		
		assertEquals(ngram8.getOverlappingFactor(ngram9), 4);
		assertEquals(ngram9.getOverlappingFactor(ngram8), 4);
		
		assertEquals(ngram9.getOverlappingFactor(ngram10), 4);
	}

}
