package com.gc.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gc.impl.Regedit;

public class RegeditAction extends Action {
	private Regedit regedit;

	public Regedit getRegedit() {
		return regedit;
	}

	public void setRegedit(Regedit regedit) {
		this.regedit = regedit;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = getRegedit().saveUser((User) form);
		request.setAttribute("msg", msg);
		request.setAttribute("user", (User) form);
		if ("register success".equals(msg)) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("input");
		}
	}
}
