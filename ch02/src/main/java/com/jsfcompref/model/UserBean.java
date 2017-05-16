package com.jsfcompref.model;

import java.util.Date;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.src.Database.TableData;

@ManagedBean
@ApplicationScoped
public class UserBean {
    
	protected int id;
	protected String firstName;
    protected String lastName;
    protected String sex;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String addConfirmedUser() {
	boolean added = true; // actual application may fail to add user
	FacesMessage doneMessage = null;
	String outcome = null;
	if (added) {
	    doneMessage = new FacesMessage("Successfully added new user");
	    outcome = "done";
	} else {
	    doneMessage = new FacesMessage("Failed to add new user");
	    outcome = "register";
	}
        FacesContext.getCurrentInstance().addMessage(null, doneMessage);
        return outcome;
    }
    
    public String updateData() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	Application application = context.getApplication();
    	ELContext elContext = context.getELContext();
    	ExpressionFactory expressionFactory = application.getExpressionFactory( );
    	ValueExpression ve = expressionFactory.createValueExpression(elContext,
    	"#{tableData}",TableData.class);
    	TableData user = (TableData) ve.getValue(elContext);
    	UserBean tmp = new UserBean();
    	tmp.setId(user.getData().size() + 1);
    	tmp.setFirstName(this.firstName);
    	user.getData().add(tmp);
    	return "register";
    }
}

