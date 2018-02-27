package com.example.app.ui.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import com.example.app.persistence.ActiveRecordManager;

public class JobListModel extends DefaultComboBoxModel<String> {
	
	private static final long serialVersionUID = 2203210028486754372L;
	private List<String> jobs;
	
	public JobListModel() {
		initialize();
	}
	
	private void initialize() {
		jobs = ActiveRecordManager.getStringList("SELECT DISTINCT job FROM people ORDER BY job");
	}

	@Override
	public String getElementAt(int index) {
		return jobs.get(index);
	}
	
	@Override
	public int getSize() {
		return jobs.size();
	}
	
	public void setSelectedItem(String anObject) {
		super.setSelectedItem(anObject);
		initialize();
	}

}
