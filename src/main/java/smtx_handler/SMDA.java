package smtx_handler;

import java.io.Serializable;
import java.util.Collections;

/** SMDA class for smda disasembly reports.
 * 
 * @author Felix Bilstein
 * @author yara-signator (at) cocacoding (dot) com
 * @version 0.1
 * @since 0.1
*/
public class SMDA implements Serializable {
	private static final long serialVersionUID = 7647370162184479335L;

	private String architecture;
	private long base_addr;
	private long bitness;
	private long buffer_size;
	private float execution_time;
	private String family;
	private String filename;
	private String message;
	private String sha256;
	private String smtx_version;
	private String status;
	private HeaderSummary summary;
	private Meta metadata;
	
	private String timestamp;
	private FunctionGraph xcfg;

	
	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public long getBase_addr() {
		return base_addr;
	}

	public void setBase_addr(long base_addr) {
		this.base_addr = base_addr;
	}

	public long getBitness() {
		return bitness;
	}

	public void setBitness(long bitness) {
		this.bitness = bitness;
	}

	public float getExecution_time() {
		return execution_time;
	}

	public void setExecution_time(float execution_time) {
		this.execution_time = execution_time;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSha256() {
		return sha256;
	}

	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	public String getSmtx_version() {
		return smtx_version;
	}

	public void setSmtx_version(String smtx_version) {
		this.smtx_version = smtx_version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HeaderSummary getSummary() {
		return summary;
	}

	public void setSummary(HeaderSummary summary) {
		this.summary = summary;
	}

	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public FunctionGraph getXcfg() {
		return xcfg;
	}
	
	public void setXcfg(FunctionGraph xcfg) {
		this.xcfg = xcfg;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void sort() {
		if(this.xcfg == null) {
			return;
		}
		for(Function f: this.xcfg.getFunctions()) {
			Collections.sort(f.getBlocks(), new BlockComparator());
			for(Block b : f.getBlocks()) {
				Collections.sort(b.getInstructions(), new InstructionComparator());
			}
		}
	}
	
	@Override
	public String toString() {
		return "SMDA [architecture=" + architecture + ", base_addr=" + base_addr + ", bitness=" + bitness
				+ ", buffer_size=" + buffer_size + ", execution_time=" + execution_time + ", family=" + family
				+ ", filename=" + filename + ", message=" + message + ", sha256=" + sha256 + ", smtx_version="
				+ smtx_version + ", status=" + status + ", summary=" + summary + ", metadata=" + metadata
				+ ", timestamp=" + timestamp + "]"
				+ "\n\nPages: "
				+ xcfg.toString();

	}

	public Meta getMeta() {
		return metadata;
	}

	public void setMeta(Meta meta) {
		this.metadata = meta;
	}

	public long getBuffer_size() {
		return buffer_size;
	}

	public void setBuffer_size(long buffer_size) {
		this.buffer_size = buffer_size;
	}
	
	
}
