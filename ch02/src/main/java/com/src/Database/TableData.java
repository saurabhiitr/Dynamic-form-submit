package com.src.Database;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.jsfcompref.model.UserBean;

@ManagedBean
@ApplicationScoped
public class TableData {
	
		List<UserBean> data = new ArrayList<UserBean>();

		public List<UserBean> getData() {
			return data;
		}

		public void setData(List<UserBean> data) {
			this.data = data;
		}
}
