package header_tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import smtx_handler.FunctionGraph;
import smtx_handler.FunctionGraphDeserializer;
import smtx_handler.SMDA;

public class TestingTemplates {
	public static SMDA testSummary(String filename) throws FileNotFoundException {
		FileReader f = new FileReader(filename);
		BufferedReader br = new BufferedReader(f, 65536);

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
		Gson gson = gsonBuilder.create();

		SMDA smda = gson.fromJson(br, SMDA.class);
		
		try {
			br.close();
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smda;
	}

}
