package uiLibary;

import java.util.ArrayList;
import java.util.List;

public class TextChoice<T> {
	private String title;
	private String cancelText;
	private String numberComplaint;
	private List<T> options;
	private ListRenderer<T> r;
	private ITextInput textInput;
	
	public TextChoice(String title, ListRenderer<T> r){
		this.title = title;
		setCancelText("Cancel");
		setNumberComplaintText("Please input a valiid ");
		options = new ArrayList<>();
		textInput = new TextInput();
		this.r = r;
	}
	
	public void addOneOption(T t) {
		options.add(t);
	}
	
	public void addListOfOptions(List<T> list) {
		for(T element : list) {
			options.add(element);
		}
	}
	
	public void isRNull() {
		
		if(r == null) {
		System.out.println("R is null");
		}
	}
	
	public T prompt(String prompt, boolean cancelAble) {
		int choice = 0;
		T res = null;
		int min;
		System.out.println(title);
		if(cancelAble == true) {
			System.out.println("[0] " + cancelText);
			min = 0;
		}else
		{
			min = 1;
		}
		for(int i = 0; i < options.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + r.display(options.get(i)));
		}
		choice = textInput.promptIntBetween(prompt, numberComplaint, min, options.size());
		
		if(choice == 0) {
			res = null;
		}else {
			res = options.get(choice - 1);
		}
		return res;
		
	}
	
	public void setCancelText(String cancel) {
		this.cancelText = cancel;
	}
	
	public void setNumberComplaintText(String complaint) {
		this.numberComplaint = complaint;
	}

	
}
