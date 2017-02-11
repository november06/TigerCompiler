package tiger.others;

public class TigerTypeException extends Exception {
    public TigerTypeException(String message) {
    	this.setMessage(message);
    }
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
}
