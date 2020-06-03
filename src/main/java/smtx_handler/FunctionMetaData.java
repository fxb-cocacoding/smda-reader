package smtx_handler;

import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;

public class FunctionMetaData {
	private double binweight;
	private String characteristics;
	private double confidence;
	private String function_name;
	
	private String pic_hash;
	
	/* Currently not supported and ALWAYS NULL */
	@Nullable
	private String strongly_connected_components;

	private float tfidf;
	
	
	public double getBinweight() {
		return binweight;
	}
	public void setBinweight(double binweight) {
		this.binweight = binweight;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getPic_hash() {
		return pic_hash;
	}
	public void setPic_hash(String pic_hash) {
		this.pic_hash = pic_hash;
	}
	public String getStrongly_connected_components() {
		return strongly_connected_components;
	}
	public void setStrongly_connected_components(String strongly_connected_components) {
		this.strongly_connected_components = strongly_connected_components;
	}
	public float getTfidf() {
		return tfidf;
	}
	public void setTfidf(float tfidf) {
		this.tfidf = tfidf;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(binweight, characteristics, confidence, function_name, pic_hash,
				strongly_connected_components, tfidf);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FunctionMetaData)) {
			return false;
		}
		FunctionMetaData other = (FunctionMetaData) obj;
		return Double.doubleToLongBits(binweight) == Double.doubleToLongBits(other.binweight)
				&& Objects.equals(characteristics, other.characteristics)
				&& Double.doubleToLongBits(confidence) == Double.doubleToLongBits(other.confidence)
				&& Objects.equals(function_name, other.function_name) && Objects.equals(pic_hash, other.pic_hash)
				&& Objects.equals(strongly_connected_components, other.strongly_connected_components)
				&& Float.floatToIntBits(tfidf) == Float.floatToIntBits(other.tfidf);
	}
	
	
	@Override
	public String toString() {
		return "FunctionMetaData [binweight=" + binweight + ", characteristics=" + characteristics + ", confidence="
				+ confidence + ", function_name=" + function_name + ", pic_hash=" + pic_hash
				+ ", strongly_connected_components=" + strongly_connected_components + ", tfidf=" + tfidf + "]";
	}
	
	
}
