package org.activitymgr.ui.web.logic;

import java.util.Calendar;
import java.util.List;

// TODO clear
public interface IContributionsLogic extends ILogic<IContributionsLogic.View> {

	static interface ICollaborator {
		String getLogin();
		String getFirstName();
		String getLastName();
	}
	
	void onPreviousYear();

	void onPreviousMonth();

	void onPreviousWeek();

	void onNextWeek();

	void onNextMonth();

	void onNextYear();

	void onDateChange(Calendar value);

	void onSelectedCollaboratorChanged(String login);

	public interface View extends ILogic.IView<IContributionsLogic> {
		
		void setCollaborators(List<ICollaborator> collaborators);
		
		void selectCollaborator(String login);

		void setColumnIdentifiers(List<String> ids);
		
		void setDate(Calendar lastMonday);

		void removeAllWeekContributions();

		void addWeekContribution(long taskId, List<ILogic.IView<?>> cellViews);
		
		void setColumnFooter(String id, String value);
		
		void addAction(IActionLogic.View actionView);
		
	}

}
