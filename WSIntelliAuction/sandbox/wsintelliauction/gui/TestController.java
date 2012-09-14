package wsintelliauction.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import wsintelliauction.task.TaskManager;

public class TestController extends Controller<TestModel, TestView> {

	public TestController(TestView view, TestModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
	}
	

	@Override
	protected void assignListeners() {
		view.getSlider1().addChangeListener(new SliderChangeListener());
		view.getSlider2().addChangeListener(new SliderChangeListener());
		view.getBtnAddValues().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JToggleButton src = (JToggleButton) arg0.getSource();
				model.setMustAdd(src.isSelected());
				if(model.isMustAdd()){
					model.updateAnswerValue();
					view.getAnswerField().setText(model.getAnswerValue()+"");
				}
				else{
					view.getAnswerField().setText("---");
				}
			}
		});
	}

	private class SliderChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			JSlider src = (JSlider) arg0.getSource();

			if (src == view.getSlider1()) {
				model.setSlider1Value(src.getValue());
				view.getTextField1().setText(model.getSlider1Value() + "");
			} else if (src == view.getSlider2()) {
				model.setSlider2Value(src.getValue());
				view.getTextField2().setText(model.getSlider2Value() + "");
			}
			if(model.isMustAdd()){
				model.updateAnswerValue();
				view.getAnswerField().setText(model.getAnswerValue()+"");
			}
		}
	}


}
