package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import smtx_handler.CodeAreas;
import smtx_handler.CodeAreasDeserializer;
import smtx_handler.DisassemblyErrors;
import smtx_handler.DisassemblyErrorsDeserializer;
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
	     * Run the custom created Deserializer, to read in the Functions.
	     * Functions have a more complex structure which is the reason we
	     * need to implement a custom Deserializer.
	     */
	    gsonBuilder.registerTypeAdapter(FunctionGraph.class, new FunctionGraphDeserializer());
	    gsonBuilder.registerTypeAdapter(CodeAreas.class, new CodeAreasDeserializer());
	    gsonBuilder.registerTypeAdapter(DisassemblyErrors.class, new DisassemblyErrorsDeserializer());
	    
	    Gson gson = gsonBuilder.create();

	    /*
	     * Might throws an illegal state exception!
	     */
	    SMDA smda = null;
	    
	    try {
	    	smda = gson.fromJson(br, SMDA.class);
	    } catch(Exception e) {
	    	System.err.println("Exception for " + filename);
	    	System.err.println("LocalMessage: \n" + e.getLocalizedMessage());
	    	System.err.println("Message: \n" + e.getMessage());
	    	System.err.println("String: \n" + e.toString());
	    	e.printStackTrace();
	    }
	    
		return smda;
	}
}
