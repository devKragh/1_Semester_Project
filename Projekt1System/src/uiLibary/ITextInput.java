package uiLibary;

public interface ITextInput {
	
	public String promptString(String question);
	
	public int promptInt(String question, String complaint);
	
	public boolean promptBoolean(String question);

	int promptIntBetween(String question, String complaint, int min, int max);

	double promptDouble(String question, String complaint);
}
