package smtx_handler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class FunctionGraphDeserializer implements JsonDeserializer<FunctionGraph> {

	@Override
	public FunctionGraph deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		FunctionGraph functionGraph = new FunctionGraph();
		functionGraph.setFunctions(new ArrayList<>());
		
		JsonObject jsonObject = json.getAsJsonObject();

		//System.out.println(jsonObject.toString());

		JsonObject elem = jsonObject.getAsJsonObject();
		//System.out.println("\n" + elem.toString());
		
        Set<Entry<String, JsonElement>> objects =  elem.entrySet();
		
        /*
         * Read all entries inside the xcfg list
         * Key is the name -> "key" { ...
         * 
         * One Page contains these entries:
         * 
         * 1 private int start_address;
		 * 2 private Collection<ApiRef> apirefs;
		 * 3 private Collection<BlockRef> blockrefs;
		 * 4 private Collection<Blocks> blocks;
		 * 5 private Collection<InRef> inrefs;
		 * 6 private int offset;
		 * 7 private Collection<OutRefs> outref;
		 * 
         */
        for (Entry<String, JsonElement> entry : objects) {
            JsonElement jsonElement  = entry.getValue();
            /*
             * A new page element
             * We will add it to the list at the end of this init method
             * 
             */
            Function p = new Function();
            
            
            // add (1) start_address
            p.setBegin(Long.parseLong(entry.getKey()));
            
            // add 2 till 5 and 7, only the initialization
            p.setApirefs(new ArrayList<>());
            p.setBlockrefs(new ArrayList<>());
            p.setBlocks(new ArrayList<>());
            p.setInrefs(new ArrayList<>());
            p.setOutref(new ArrayList<>());
            
            /**
             * ToDo: Do this stuff with exceptions, really ugly workaround
             */
            if(jsonElement.isJsonObject()) {
            	JsonObject eachPage = jsonElement.getAsJsonObject();
            	
            	// parse the (2) apirefs
            	JsonElement jsonElemApirefs = eachPage.get("apirefs");
            	if(jsonElemApirefs != null && jsonElemApirefs.isJsonObject()) {
            		JsonObject jsonApirefs = jsonElemApirefs.getAsJsonObject();
            		Set<Entry<String, JsonElement>> apirefs =  jsonApirefs.entrySet();
                    for (Entry<String, JsonElement> apiRefEntry : apirefs) {
                    	ApiRef a = new ApiRef();
                    	a.setOffset(Long.parseLong(apiRefEntry.getKey()));
                    	a.setApicall(apiRefEntry.getValue().getAsString());
                    	p.getApirefs().add(a);
                    }
            	}
            	
            	//parse the (3) blockrefs
            	JsonElement jsonElemBlockrefs = eachPage.get("blockrefs");
            	if(jsonElemBlockrefs != null && jsonElemBlockrefs.isJsonObject()) {
            		JsonObject jsonBlockrefs = jsonElemBlockrefs.getAsJsonObject();
            		Set<Entry<String, JsonElement>> blockrefs =  jsonBlockrefs.entrySet();
            		for (Entry<String, JsonElement> blockRefEntry : blockrefs) {
                    	if(blockRefEntry.getValue().isJsonArray()) {
                    		BlockRef b = new BlockRef();
                    		b.setRefs(new ArrayList<>());
                    		b.setOffset(Long.parseLong(blockRefEntry.getKey()));
                    		
                    		JsonArray refs = blockRefEntry.getValue().getAsJsonArray();
                    		for(int i = 0; i<refs.size(); i++)
                    			b.getRefs().add(refs.get(i).getAsLong());
                    		p.getBlockrefs().add(b);
                    	}
                    }
            	}
            	
            	//parse the (4) blocks - very nested json structure.
            	JsonElement jsonElemBlocks = eachPage.get("blocks");
            	if(jsonElemBlocks.isJsonObject()) {
            		JsonObject jsonBlocks = jsonElemBlocks.getAsJsonObject();
            		Set<Entry<String, JsonElement>> blocks = jsonBlocks.entrySet();
            		for(Entry<String, JsonElement> blocksEntry : blocks) {
            			String blockname = blocksEntry.getKey();
            			if(blocksEntry.getValue().isJsonArray()) {
            				Block bA = new Block();
            				bA.setBlockOffset(blockname);
            				bA.setInstructions(new ArrayList<>());
            				
            				JsonArray blockarrays = blocksEntry.getValue().getAsJsonArray();
            				for(int i=0; i<blockarrays.size(); i++) {
            					Instruction intstruction = new Instruction();
            					if(blockarrays.get(i).isJsonArray()) {
            						/*
            						 * Block is always like this:
            						 *       1353092,
      								 * 		"c9",
      								 * 		"leave",
      								 * 		""
      								 * always 4 lines, each line an entry, address, opcode, 2 mnenos
      								 * 
            						 */
            						JsonArray block = blockarrays.get(i).getAsJsonArray();
    								intstruction.setOffset(block.get(0).getAsLong());
    								intstruction.setOpcodes(block.get(1).getAsString());
    								intstruction.setMnemonics(new ArrayList<>());
            						for(int j=2; j<block.size(); j++) {
            							intstruction.getMnemonics().add(block.get(j).getAsString());
            						}
            					}
                				bA.getInstructions().add(intstruction);
            				}
            				p.getBlocks().add(bA);
            			}
            		}
            	}
            	
            	// parse (5) inrefs
            	JsonElement jsonElemInRefs = eachPage.get("inrefs");
            	if(jsonElemInRefs != null && jsonElemInRefs.isJsonArray()) {
            		JsonArray jsonAllAddresses = jsonElemInRefs.getAsJsonArray();
            		for(int i=0; i<jsonAllAddresses.size(); i++) {
            			p.getInrefs().add(jsonAllAddresses.get(i).getAsLong());
            		}
            	}
            	
            	// add (6) offset
            	p.setOffsets(eachPage.get("offset").getAsLong());
            	
            	// parse (7) outref
            	JsonElement jsonElemOutRefs = eachPage.get("outrefs");
            	if(jsonElemOutRefs.isJsonObject()) {
            		JsonObject jsonOutRefs = jsonElemOutRefs.getAsJsonObject();
            		Set<Entry<String, JsonElement>> outrefs = jsonOutRefs.entrySet();
            		for(Entry<String, JsonElement> outrefsEntry : outrefs) {
            			OutRef outref = new OutRef();
            			outref.setOutrefs(new ArrayList<>());
            			outref.setOutrefOffset(outrefsEntry.getKey());
            			if(outrefsEntry.getValue().isJsonArray()) {
            				JsonArray refs = outrefsEntry.getValue().getAsJsonArray();
                    		for(int i = 0; i<refs.size(); i++)
                    		outref.getOutrefs().add(refs.get(i).getAsLong());
            			}
            			p.getOutref().add(outref);
            		}
            	}
            }
            functionGraph.getFunctions().add(p);
        }
		return functionGraph;
	}

}
