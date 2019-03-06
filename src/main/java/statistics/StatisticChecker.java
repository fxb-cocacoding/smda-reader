package statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import converters.ConverterFactory;
import converters.linearization.Linearization;
import smtx_handler.Function;
import smtx_handler.FunctionGraph;
import smtx_handler.FunctionGraphDeserializer;
import smtx_handler.Instruction;
import smtx_handler.OutRef;
import smtx_handler.SMDA;
import statistics.instructions.InstructionOccurrenceCounter;
import statistics.instructions.InstructionsUsed;

public class StatisticChecker {
	
	public class ValueComparator<String, Long extends Comparable<Long>> implements Comparator<Long> {
		 
		HashMap<String, Long> map = new HashMap<String, Long>();
	 
		public ValueComparator(HashMap<String, Long> map){
			this.map.putAll(map);
		}
	 
		@Override
		public int compare(Long s1, Long s2) {
			return -map.get(s1).compareTo(map.get(s2));//descending order	
		}

	}
	
	public static void main(String[] argv) {
		
		
		FileReader f = null;
		try {
			f = new FileReader("src/test/resources/smda_samples/win.citadel/fcc8370fcb067bbb5bc17c513febdb13686f7a7c1b3df99d2be6e573017df0e6_dump_0x02390000.smda");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(f, 65536);

	    GsonBuilder gsonBuilder = new GsonBuilder();

	    //Run the custom created Deserializer, to read in the Pages.
	    //Pages is the container class, containing 

	    gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
	    Gson gson = gsonBuilder.create();

	    
		SMDA smda = gson.fromJson(br, SMDA.class);
		//System.out.println(smda.toString());
		
		long all = 0;
		
		
		//get all basic blocks

		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getBlocks().size();
		}
		
		//get all functions
		//all = smda.getXcfg().getFunctions().size();


		//To get all instructions, iterate over every function, each size of ArrayList of block 
		
		
		System.out.println("CALC: " + all);
		System.out.println(smda.getSummary());
		
		Set<OutRef> s = new HashSet<>();
		for(Function a : smda.getXcfg().getFunctions()) {
			for(OutRef outref : a.getOutref()) {
				s.add(outref);
			}
		}
		
		System.out.println("outrefs: " + s.size());
		
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		InstructionOccurrenceCounter ic = new InstructionOccurrenceCounter(smda);
		ic.countInstructionOccurence();
		System.out.println(ic.toNiceString());
		InstructionsUsed iu = new InstructionsUsed(smda);
		iu.countInstructions();
		System.out.println(iu.toNiceString());
		
		*/
		
		
		List<List<Instruction>> l = new ConverterFactory().getLinearized(smda);
		System.out.println("\n\n\n\nWait for it\n\n\n");
		int code_cave = 0;
		boolean function = false;
		for(List<Instruction> k : l) {
			long old_offset = 0;
			int old_asm = 0;
			for(Instruction i : k) {
				if(i.getOpcodes().equalsIgnoreCase("55")) function = true;
				if(i.getOffset() != old_offset + old_asm && i.getOffset() != 37301128) {
					System.out.println("//code cave");
					code_cave++;
				}
				System.out.println(i.toStringInDisassemblyView());
				old_offset = i.getOffset();
				old_asm = i.getAssemblySize();
			}
			if(code_cave == 1 && function == true) break;
			function = false;
		}
		
		
		
		
		
		
		//generateBasicStatistics();
		//generateInstructionStatistics();
		
		
		
		
		/*
		
		
		FileReader f = null;
		try {
			f = new FileReader("src/test/resources/smda_samples/win.citadel/fcc8370fcb067bbb5bc17c513febdb13686f7a7c1b3df99d2be6e573017df0e6_dump_0x02390000.smda");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(f, 65536);

	    GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
	    Gson gson = gsonBuilder.create();
		SMDA smda = gson.fromJson(br, SMDA.class);
		
		long all = 0;

		for(Function a : smda.getXcfg().getFunctions()) {
			all += a.getBlocks().size();
		}

		System.out.println("CALC: " + all);
		System.out.println(smda.getSummary());
		
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InstructionOccurenceCounter ic = new InstructionOccurenceCounter(smda);
		ic.countInstructionOccurence();
		
		System.out.println(ic.toNiceString());
		//InstructionsUsed iu = new InstructionsUsed(smda);
		//iu.countInstructions();
		//System.out.println(iu.toNiceString());
		*/
	}

	public static void generateInstructionStatistics() {
		FileReader f;
		BufferedReader br;
		GsonBuilder gsonBuilder;
		Gson gson;
		SMDA smda;
		long startTime = System.nanoTime();
		
		//https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
		//File folder = new File("/home/fxb/BachelorThesis/2018-06-07-smda_reports/smda_reports");
		File folder = new File("/home/fxb/BachelorThesis/thesis/smda_reports");
		File[] listOfFiles = folder.listFiles();

		int i = 0;
		
		//files: 1935
		System.out.println("files: " + listOfFiles.length);
		
		List<Map<String, Long>> allOccurences = new ArrayList<Map<String,Long>>();
		
		for(File file : listOfFiles) {
			f = null;
			try {
				f = new FileReader(file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br = new BufferedReader(f, 65536);
	
		    gsonBuilder = new GsonBuilder();

		    //Run the custom created Deserializer, to read in the Pages.
		    //Pages is the container class, containing 
		    gson = null;
		    smda = null;
		    try {
		    	gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
		    	gson = gsonBuilder.create();
		    	smda = gson.fromJson(br, SMDA.class);
		    } catch (Exception e) {
				e.printStackTrace();
				System.out.println(file.toString());
			}
		    
			if(smda != null) {
				if(smda.getSummary() != null) {
					if (i%25 == 0) System.out.print(".");
					if (i%100 == 0) System.out.print("#");
					if(smda.getSummary().getNum_instructions() >= 10) {
						InstructionOccurrenceCounter ic = new InstructionOccurrenceCounter(smda);
						ic.countInstructionOccurence();
						allOccurences.add(ic.getInstructionTuples());
					}
				}
			}
			i++;
		}
		
		
		Map<String,Long> ret = new HashMap<String,Long>();

		int index = 0;
		for(Map<String, Long> map : allOccurences) {

			for(Entry<String, Long> e : map.entrySet()) {
				String key = e.getKey();
				Long value = e.getValue();
				
				if(!ret.containsKey(key)) {
					ret.put(key, value);
				} else {
					Long old_value = ret.get(key);
					ret.put(key, old_value + value);
				}
			}
			
			index++;
		}
				
		LinkedHashMap<String, Long> orderedDesc = new LinkedHashMap<String, Long>();
		ret.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> orderedDesc.put(x.getKey(), x.getValue()));
		
		System.out.println();
		System.out.println("files found: " + index);
		System.out.println();
		
		index = 0;
		double probe = 0;
		DecimalFormat dc = new DecimalFormat("#.00");
		
		System.out.println("different instructions: " + ret.size());
		System.out.println("absolute: " + ret.toString());
		System.out.println("relative: \n");
		for(Entry<String, Long> e : orderedDesc.entrySet()) {
			index++;
			System.out.print(index + " & ");
			System.out.print(e.getKey());
			/*
			if(e.getKey().length()<4) {
				System.out.print("\t\t\t\t");
			} else if(e.getKey().length()<8) {
				System.out.print("\t\t\t");
			} else if (e.getKey().length()<12){
				System.out.print("\t\t");
			} else {
				System.out.print("\t");
			}
			*/
			System.out.print(" & ");
			if(e.getValue()/1828.0 < 0) System.out.print("0");
			System.out.print( dc.format( e.getValue()/1828.0 ) + " & ");
			if(((e.getValue()/1828.0)/44720.0)*100 < 0) System.out.print("0");
			System.out.print( dc.format(((e.getValue()/1828.0)/44720.0)*100) + "\\%\\\\");
			probe += ((e.getValue()/1828.0)/44720.0)*100;
			System.out.println();
		}
		
		System.out.println("probe: " + probe);
	}
	
	public static void generateBasicStatistics() {
		FileReader f;
		BufferedReader br;
		GsonBuilder gsonBuilder;
		Gson gson;
		SMDA smda;
		long startTime = System.nanoTime();
		
		//https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
		//File folder = new File("/home/fxb/BachelorThesis/2018-06-07-smda_reports/smda_reports");
		File folder = new File("/home/fxb/BachelorThesis/thesis/smda_reports");
		File[] listOfFiles = folder.listFiles();
		
		ArrayList<Long> bitness = new ArrayList<>();
		ArrayList<Long> num_instructions = new ArrayList<>();
		ArrayList<Long> num_functions = new ArrayList<>();
		ArrayList<Long> num_function_calls = new ArrayList<>();
		ArrayList<Long> num_recursive_functions = new ArrayList<>();
		ArrayList<Long> num_api_calls = new ArrayList<>();
		ArrayList<Long> num_basic_blocks = new ArrayList<>();
		ArrayList<Long> num_leaf_functions = new ArrayList<>();
		
		int i = 0;
		
		//files: 1935
		System.out.println("files: " + listOfFiles.length);
		for(File file : listOfFiles) {
			//System.out.println(file.getAbsolutePath());
			//System.out.println("Progress: " + 100*((float)i/(float) listOfFiles.length) );
			f = null;
			try {
				f = new FileReader(file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br = new BufferedReader(f, 65536);
	
		    gsonBuilder = new GsonBuilder();

		    //Run the custom created Deserializer, to read in the Pages.
		    //Pages is the container class, containing 
		    gson = null;
		    smda = null;
		    try {
		    	gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
		    	gson = gsonBuilder.create();
		    	smda = gson.fromJson(br, SMDA.class);
		    } catch (Exception e) {
				e.printStackTrace();
				System.out.println(file.toString());
			}
			
			if(smda != null) {
				bitness.add(smda.getBitness());
				if(smda.getSummary() != null) {
					if (i%10 == 0) System.out.print(".");
					num_instructions.add(smda.getSummary().getNum_instructions());
					num_function_calls.add(smda.getSummary().getNum_function_calls());
					num_functions.add(smda.getSummary().getNum_functions());
					num_recursive_functions.add(smda.getSummary().getNum_recursive_functions());
					num_api_calls.add(smda.getSummary().getNum_api_calls());
					num_basic_blocks.add(smda.getSummary().getNum_basic_blocks());
					num_leaf_functions.add(smda.getSummary().getNum_leaf_functions());
				} else {
					System.out.println("progress: " + i + " no summary: " + smda.getFilename() + " smtx: " + smda.getSmtx_version() + " arch: " + smda.getArchitecture());
				}
			} else {
				System.out.println("progress: " + i + " no smda: " + file.getAbsolutePath());
				System.out.println("zero?");
			}
			
			smda = null;
			gson = null;
			gsonBuilder = null;
			i++;
		}
		int bitness_32 = 0;
		int bitness_64 = 0;
		for(int j=0;j<bitness.size();j++) {
			if(bitness.get(j).toString().equals("32"))
				bitness_32++;
			else if(bitness.get(j).toString().equals("64"))
				bitness_64++;
			else if(bitness.get(j) == null)
				System.out.println("j: " + j + " is null " + listOfFiles[j]);
			else {
				System.out.println("j: " + j  + " " + listOfFiles[j].getAbsolutePath());
				System.out.println(bitness.get(j).toString());
			}
		}
		
		
		double double_num_instructions_avg = 0;
		double double_num_api_calls = 0;
		double double_num_basic_blocks = 0;
		double double_num_function_calls = 0;
		double double_num_functions = 0;
		double double_num_leaf_functions = 0;
		double double_num_recursive_functions = 0;
				
		int realCount = 0;
		
		for(int j=0;j<num_instructions.size();j++) {
			if(num_instructions.get(j) >= 10) {
				realCount++;
				double_num_instructions_avg += num_instructions.get(j)/((double)1828);
				double_num_api_calls += num_api_calls.get(j)/((double)1828);
				double_num_basic_blocks += num_basic_blocks.get(j)/((double)1828);
				double_num_functions += num_functions.get(j)/((double)1828);
				double_num_function_calls += num_function_calls.get(j)/((double)1828);
				double_num_leaf_functions += num_leaf_functions.get(j)/((double)1828);
				double_num_recursive_functions += num_recursive_functions.get(j)/((double)1828);
			}
		}
		
		System.out.println("num_instructions_avg: " + double_num_instructions_avg);
		System.out.println("num_api_calls_avg: " + double_num_api_calls);
		System.out.println("num_basic_blocks: " + double_num_basic_blocks);
		System.out.println("num_functions: " + double_num_functions);
		System.out.println("num_function_calls: " + double_num_function_calls);
		System.out.println("num_leaf_functions: " + double_num_leaf_functions);
		System.out.println("num_recursive_functions: " + double_num_recursive_functions);
		
		System.out.println("realCount: " + realCount);
		System.out.println("count: " + i);
		System.out.println("32: " + bitness_32);
		System.out.println("64: " + bitness_64);
		
		long endTime = System.nanoTime();

		long duration = ((endTime - startTime)/1000000);
		System.out.println("Duration: " + duration + "ms");
	}
}
