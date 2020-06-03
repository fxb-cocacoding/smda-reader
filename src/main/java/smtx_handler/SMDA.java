package smtx_handler;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.signedness.qual.Unsigned;

/** SMDA class for smda disasembly reports.
 * 
 * @author Felix Bilstein
 * @author yara-signator (at) cocacoding (dot) com
 * @version 0.4.0
 * @since 0.1
*/
public class SMDA implements Serializable {
	private static final long serialVersionUID = 7647370162184479335L;

	private String architecture;
	
	@Unsigned
	private long base_addr;
	
	@Unsigned
	private long binary_size;
	
	// Should be only 32 or 64 bit.
	@Unsigned
	private byte bitness;
	
	@Nullable
	private CodeAreas code_areas;
	// Should be null for the begin.
	
	private double confidence_threshold;
	
	@Nullable
	private DisassemblyErrors disassembly_errors;
	// Should be null for the begin.
	
	private float execution_time;
	private int identified_alignment;
	private String message;
	
	private Meta metadata;
	
	private String sha256;
	private String smda_version;
	
	private Statistics statistics;
	
	private String status;
	
	private String timestamp;
	private FunctionGraph xcfg;
	
	
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


	public long getBinary_size() {
		return binary_size;
	}


	public void setBinary_size(long binary_size) {
		this.binary_size = binary_size;
	}


	public byte getBitness() {
		return bitness;
	}


	public void setBitness(byte bitness) {
		this.bitness = bitness;
	}


	public CodeAreas getCode_areas() {
		return code_areas;
	}


	public void setCode_areas(CodeAreas code_areas) {
		this.code_areas = code_areas;
	}


	public double getConfidence_threshold() {
		return confidence_threshold;
	}


	public void setConfidence_threshold(double confidence_threshold) {
		this.confidence_threshold = confidence_threshold;
	}


	public DisassemblyErrors getDisassembly_errors() {
		return disassembly_errors;
	}


	public void setDisassembly_errors(DisassemblyErrors disassembly_errors) {
		this.disassembly_errors = disassembly_errors;
	}


	public float getExecution_time() {
		return execution_time;
	}


	public void setExecution_time(float execution_time) {
		this.execution_time = execution_time;
	}


	public int getIdentified_alignment() {
		return identified_alignment;
	}


	public void setIdentified_alignment(int identified_alignment) {
		this.identified_alignment = identified_alignment;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Meta getMetadata() {
		return metadata;
	}


	public void setMetadata(Meta metadata) {
		this.metadata = metadata;
	}


	public String getSha256() {
		return sha256;
	}


	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}


	public String getSmda_version() {
		return smda_version;
	}


	public void setSmda_version(String smda_version) {
		this.smda_version = smda_version;
	}


	public Statistics getStatistics() {
		return statistics;
	}


	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	@Override
	public int hashCode() {
		return Objects.hash(architecture, base_addr, binary_size, bitness, code_areas, confidence_threshold,
				disassembly_errors, execution_time, identified_alignment, message, metadata, sha256, smda_version,
				statistics, status, timestamp, xcfg);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SMDA)) {
			return false;
		}
		SMDA other = (SMDA) obj;
		return Objects.equals(architecture, other.architecture) && base_addr == other.base_addr
				&& binary_size == other.binary_size && bitness == other.bitness
				&& Objects.equals(code_areas, other.code_areas)
				&& Double.doubleToLongBits(confidence_threshold) == Double.doubleToLongBits(other.confidence_threshold)
				&& Objects.equals(disassembly_errors, other.disassembly_errors)
				&& Float.floatToIntBits(execution_time) == Float.floatToIntBits(other.execution_time)
				&& identified_alignment == other.identified_alignment && Objects.equals(message, other.message)
				&& Objects.equals(metadata, other.metadata) && Objects.equals(sha256, other.sha256)
				&& Objects.equals(smda_version, other.smda_version) && Objects.equals(statistics, other.statistics)
				&& Objects.equals(status, other.status) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(xcfg, other.xcfg);
	}


	@Override
	public String toString() {
		return "SMDA [architecture=" + architecture + ", base_addr=" + base_addr + ", binary_size=" + binary_size
				+ ", bitness=" + bitness + ", code_areas=" + code_areas + ", confidence_threshold="
				+ confidence_threshold + ", disassembly_errors=" + disassembly_errors + ", execution_time="
				+ execution_time + ", identified_alignment=" + identified_alignment + ", message=" + message
				+ ", metadata=" + metadata + ", sha256=" + sha256 + ", smda_version=" + smda_version + ", statistics="
				+ statistics + ", status=" + status + ", timestamp=" + timestamp + ", xcfg=" + xcfg + "]";
	}
	
	
}
