package wsintelliauction.gui;

import wsintelliauction.gui.Model;

public class TestModel extends Model {
	
	private int slider1Value;
	private int slider2Value;
	private boolean mustAdd;
	private int answerValue;

	@Override
	public void reset() {
		slider1Value = 50;
		slider2Value = 50;
		answerValue = slider1Value + slider2Value;
		mustAdd = false;
	}
	
	public boolean isMustAdd() {
		return mustAdd;
	}
	
	public void setMustAdd(boolean mustAdd) {
		this.mustAdd = mustAdd;
	}
	
	public int getSlider1Value() {
		return slider1Value;
	}
	
	public int getSlider2Value() {
		return slider2Value;
	}
	
	public void setSlider1Value(int slider1Value) {
		this.slider1Value = slider1Value;
	}
	
	public void setSlider2Value(int slider2Value) {
		this.slider2Value = slider2Value;
	}
	
	public void updateAnswerValue(){
		answerValue = slider1Value + slider2Value;
	}
	
	public int getAnswerValue() {
		return answerValue;
	}

}
