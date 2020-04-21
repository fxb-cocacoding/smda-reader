package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import smtx_handler.FunctionGraph;
import smtx_handler.FunctionGraphDeserializer;
import smtx_handler.SMDA;

public class Generator {
	public SMDA generateSMDA(String filename) throws java.lang.IllegalStateException {
		FileReader f = null;
		try {
			f = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(f, 65536);

	    GsonBuilder gsonBuilder = new GsonBuilder();
	    /*
	     * Run the custom created Deserializer, to read in the Pages.
	     * Pages is the container class, containing 
	     */
	    gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
	    Gson gson = gsonBuilder.create();

	    /*
	     * Might throws an illegal state exception!
	     */
	    SMDA smda = gson.fromJson(br, SMDA.class);
	    
	    
		return smda;
	}
}
