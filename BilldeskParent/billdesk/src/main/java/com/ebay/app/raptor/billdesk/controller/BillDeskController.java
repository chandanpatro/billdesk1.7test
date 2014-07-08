package com.ebay.app.raptor.billdesk.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.CRC32;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebay.app.raptor.billdesk.Model.BillDeskModel;
import com.ebay.raptor.kernel.context.IRaptorContext;

@Controller
public class BillDeskController {
	
	@Inject IRaptorContext raptorCtx;
	
	private static final long serialVersionUID = -1;
	private static final String PAYLOAD_DELIMETER = "|";
	
	//Auth Status
	private static final String SUCCESS = "0300";
	private static final String IN_VALID_AUTHN_AT_BANK = "0399";
	private static final String IN_VALID_INPUT  = "NA";
	private static final String BD_WAITING = "0002";
	private static final String BD_ERROR = "0001";
	
	 ModelAndView mv = new ModelAndView();
	
	@RequestMapping(value = "billdesksimulator", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView handlebilldesksim(HttpServletRequest request) {
		
		//loadChecksum();
		//BillDeskModel billdeskModel = new BillDeskModel();
		BillDeskModel to = constructTo(request);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		if(to.TxnReferenceNo == null || "EBAY".equals(to.TxnReferenceNo))
			to.TxnReferenceNo =  "EBAY" + getRandomNum(10);
		if(to.TxnDate == null)
			to.TxnDate = format.format(new Date());
		if(to.AuthStatus == null)
			to.AuthStatus = SUCCESS; 
		if(to.ErrorStatus == null)
			to.ErrorStatus = "NA";
		if(to.ErrorDescription == null)
			to.ErrorDescription = "Success";				
			
		if(!to.isValidInputParam)
		{
			//resp.setContentType("text/plain");
			//resp.getWriter().println("Basic Input Validation failed. Flow cannot continue :-( ");
		}
		
		responseBuilder(to);
		
		//request.setAttribute("model", to);
		
		request.setAttribute("msg", to.getMsg());
		request.setAttribute("hidRequestId", to.getHidRequestId());
		request.setAttribute("hidOperation", to.getHidOperation());
		
		request.setAttribute("RU", to.getRU());
		
		Enumeration<String> enum1 = (Enumeration<String>) request.getParameterNames();
		String requestPayload = "";
		while (enum1.hasMoreElements()) 
		{
			String key = (String) enum1.nextElement();
			String value = request.getParameter(key);
			requestPayload += key + " : \t" + value + "<br />";
		}
		request.setAttribute("payload", requestPayload);
		
		mv.addObject("billdeskModel", to);
        mv.setViewName("RedirectResponse");
		
		return mv;
		
		
	}
	
	private BillDeskModel constructTo(HttpServletRequest req) 
	{
		BillDeskModel to = new BillDeskModel();
		to.hidRequestId = req.getParameter("hidRequestId");
		to.hidOperation = req.getParameter("hidOperation");
		to.billerid = req.getParameter("billerid");
		to.txtBankID = req.getParameter("txtBankID");
		to.txtItemCode = req.getParameter("txtItemCode");
		to.txtCustomerID = req.getParameter("txtCustomerID");
		to.txtTxnAmount = req.getParameter("txtTxnAmount");
		to.RU = req.getParameter("RU");
		to.REQ = req.getParameter("REQ");
		
		//Additional Param handler
		to.txtAdditionalInfo1 = (req.getParameter("txtAdditionalInfo1") == null)?"NA":req.getParameter("txtAdditionalInfo1");
		to.txtAdditionalInfo2 = (req.getParameter("txtAdditionalInfo2") == null)?"NA":req.getParameter("txtAdditionalInfo2");
		to.txtAdditionalInfo3 = (req.getParameter("txtAdditionalInfo3") == null)?"NA":req.getParameter("txtAdditionalInfo3");
		to.txtAdditionalInfo4 = (req.getParameter("txtAdditionalInfo4") == null)?"NA":req.getParameter("txtAdditionalInfo4");
		to.txtAdditionalInfo5 = (req.getParameter("txtAdditionalInfo5") == null)?"NA":req.getParameter("txtAdditionalInfo5");
		to.txtAdditionalInfo6 = (req.getParameter("txtAdditionalInfo6") == null)?"NA":req.getParameter("txtAdditionalInfo6");
		to.txtAdditionalInfo7 = (req.getParameter("txtAdditionalInfo7") == null)?"NA":req.getParameter("txtAdditionalInfo7");
		
		//Response Params
		to.checksum = req.getParameter("checksum");
		to.TxnReferenceNo = req.getParameter("TxnReferenceNo");
		to.ErrorStatus = req.getParameter("ErrorStatus");
		to.AuthStatus = req.getParameter("AuthStatus");
		to.ErrorDescription = req.getParameter("ErrorDescription");
		to.TxnDate = req.getParameter("TxnDate");
		
		return to;
	}
	
	private void responseBuilder(BillDeskModel to)
	{
		if ((isNullOrEmpty(to.hidRequestId)) || (isNullOrEmpty(to.hidOperation)) || (isNullOrEmpty(to.RU))) 
		{
			to.isValidInputParam = false;
		}

		String respString = to.billerid + PAYLOAD_DELIMETER + to.txtCustomerID + PAYLOAD_DELIMETER + to.TxnReferenceNo + PAYLOAD_DELIMETER + getRandomNum(6) + PAYLOAD_DELIMETER + to.txtTxnAmount
				+ PAYLOAD_DELIMETER + to.txtBankID + PAYLOAD_DELIMETER + "NA|NA|INR" + PAYLOAD_DELIMETER + to.txtItemCode
				+ "|NA|NA|NA|" + to.TxnDate + PAYLOAD_DELIMETER + to.AuthStatus + "|NA|"
				+ to.txtAdditionalInfo1 + PAYLOAD_DELIMETER + to.txtAdditionalInfo2 + PAYLOAD_DELIMETER
				+ to.txtAdditionalInfo3 + PAYLOAD_DELIMETER + to.txtAdditionalInfo4 + PAYLOAD_DELIMETER
				+ to.txtAdditionalInfo5 + PAYLOAD_DELIMETER + to.txtAdditionalInfo6 + PAYLOAD_DELIMETER + to.txtAdditionalInfo7 + "|NA|" + to.ErrorDescription;

		try {
			respString = respString  + PAYLOAD_DELIMETER + getCheckSum(respString);
		} catch (Exception e) {
			respString = e.getMessage();
		}
		
		to.msg = respString;
	}

	public boolean isNullOrEmpty(String input) 
	{
		return (input == null) || (input.trim().length() == 0);
	}

	public long getRandomNum(int length) 
	{
		return (long) (Math.random() * Math.pow(10.0D, length));
	}

	
	public String getCheckSum(String input) throws Exception
	{
		String checkSumKey ="CuMWiLw1V5FC"; //(String)getServletContext().getAttribute("checksumKey");
		
		if(checkSumKey == null || checkSumKey.trim().equalsIgnoreCase("null"))
			throw new Exception("Invalid Checksum key");
		
		return doDigest(input, checkSumKey);
	}
	
	public static String doDigest(String paramString1, String paramString2) throws Exception
	{
		String str = null;
		CRC32 localCRC32 = new CRC32();
		
		paramString1 = paramString1 + "|" + paramString2;
		localCRC32.update(paramString1.getBytes());
		str = String.valueOf(localCRC32.getValue());
		
		return str;
	}

}
