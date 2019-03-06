package smtx_handler;

import java.io.Serializable;
import java.util.List;

public class Function implements Serializable {
	private static final long serialVersionUID = 7638277624135753064L;

	private long begin;
	private List<ApiRef> apirefs;
	private List<BlockRef> blockrefs;
	private List<Block> blocks;
	private List<Long> inrefs;
	private long offset;
	private List<OutRef> outref;
	
	public long getBegin() {
		return begin;
	}
	
	public void setBegin(long begin) {
		this.begin = begin;
	}
	
	public List<ApiRef> getApirefs() {
		return apirefs;
	}
	
	public void setApirefs(List<ApiRef> apirefs) {
		this.apirefs = apirefs;
	}
	
	public List<BlockRef> getBlockrefs() {
		return blockrefs;
	}
	
	public void setBlockrefs(List<BlockRef> blockrefs) {
		this.blockrefs = blockrefs;
	}
	
	public List<Block> getBlocks() {
		return blocks;
	}
	
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Long> getInrefs() {
		return inrefs;
	}

	public void setInrefs(List<Long> inrefs) {
		this.inrefs = inrefs;
	}

	public long getOffsets() {
		return offset;
	}

	public void setOffsets(long offsets) {
		this.offset = offsets;
	}

	public List<OutRef> getOutref() {
		return outref;
	}

	public void setOutref(List<OutRef> outref) {
		this.outref = outref;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("apirefs: ");
		for(ApiRef api : apirefs)
			sb.append(api.toString());
		sb.append("\n");
		sb.append("blockrefs: ");
		for(BlockRef ref : blockrefs)
			sb.append(ref.toString());
		sb.append("\n");
		sb.append("blocks: ");
		for(Block blocks : blocks)
			sb.append(blocks.toString());
		sb.append("\n");
		sb.append("inrefs: ");
		sb.append(inrefs.toString());
		sb.append("\n");
		sb.append("offset: ");
		sb.append(offset);
		sb.append("\n");
		sb.append("outref: ");
		for(OutRef out : outref)
			sb.append(out.toString());
		sb.append("\n");
		
		return sb.toString();
		
	}
}