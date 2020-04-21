package smtx_handler;

public class Meta {
	private String family;
	private String malpedia_filepath;
	private String message;
	
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMalpedia_filepath() {
		return malpedia_filepath;
	}
	public void setMalpedia_filepath(String malpedia_filepath) {
		this.malpedia_filepath = malpedia_filepath;
	}
	
	@Override
	public String toString() {
		return "Meta [family=" + family + ", malpedia_filepath=" + malpedia_filepath + ", message=" + message + "]";
	}
}
