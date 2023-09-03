package util;

public enum ProgramParameters {
	FILE_PATH(0);
	
	private int Value;
	
	ProgramParameters(int pValue) {
		setValue(pValue);
	}

	public int getValue() {
		return Value;
	}
	public void setValue(int pValue) {
		Value = pValue;
	}
}