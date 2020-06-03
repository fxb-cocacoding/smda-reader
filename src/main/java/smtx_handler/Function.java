package smtx_handler;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Function implements Serializable {
	private static final long serialVersionUID = 7638277624135753064L;

	private long begin;
	private List<ApiRef> apirefs;
	private List<BlockRef> blockrefs;
	private List<Block> blocks;
	private List<Long> inrefs;
	private long offset;
	private FunctionMetaData metadata;
	private List<OutRef> outrefs;
	
	
	
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
		for(OutRef out : outrefs)
			sb.append(out.toString());
		sb.append("\n");
		
		return sb.toString();
		
	}



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



	public List<Long> getInrefs() {
		return inrefs;
	}



	public void setInrefs(List<Long> inrefs) {
		this.inrefs = inrefs;
	}



	public long getOffset() {
		return offset;
	}



	public void setOffset(long offset) {
		this.offset = offset;
	}



	public FunctionMetaData getMetadata() {
		return metadata;
	}



	public void setMetadata(FunctionMetaData metadata) {
		this.metadata = metadata;
	}



	public List<OutRef> getOutrefs() {
		return outrefs;
	}



	public void setOutrefs(List<OutRef> outrefs) {
		this.outrefs = outrefs;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(apirefs, begin, blockrefs, blocks, inrefs, metadata, offset, outrefs);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Function)) {
			return false;
		}
		Function other = (Function) obj;
		return Objects.equals(apirefs, other.apirefs) && begin == other.begin
				&& Objects.equals(blockrefs, other.blockrefs) && Objects.equals(blocks, other.blocks)
				&& Objects.equals(inrefs, other.inrefs) && Objects.equals(metadata, other.metadata)
				&& offset == other.offset && Objects.equals(outrefs, other.outrefs);
	}
}