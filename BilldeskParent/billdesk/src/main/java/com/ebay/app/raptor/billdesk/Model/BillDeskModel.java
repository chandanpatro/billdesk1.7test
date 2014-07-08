package com.ebay.app.raptor.billdesk.Model;

public class BillDeskModel {
	
	public String hidRequestId;
	public String hidOperation;
	public String billerid;
	public String txtBankID;
	public String txtItemCode;
	public String txtCustomerID;
	public String txtTxnAmount;
	public String RU;

	public String checksum;
	public String TxnDate;
	public String TxnReferenceNo;
	public String ErrorStatus;
	public String AuthStatus;
	public String ErrorDescription;
	public String msg;

	// Additional Parameters
	public String txtAdditionalInfo1;
	public String txtAdditionalInfo2;
	public String txtAdditionalInfo3;
	public String txtAdditionalInfo4;
	public String txtAdditionalInfo5;
	public String txtAdditionalInfo6;
	public String txtAdditionalInfo7;

	// Simulator internal
	public String REQ;
	public String getHidRequestId() {
		return hidRequestId;
	}
	public void setHidRequestId(String hidRequestId) {
		this.hidRequestId = hidRequestId;
	}
	public String getHidOperation() {
		return hidOperation;
	}
	public void setHidOperation(String hidOperation) {
		this.hidOperation = hidOperation;
	}
	public String getBillerid() {
		return billerid;
	}
	public void setBillerid(String billerid) {
		this.billerid = billerid;
	}
	public String getTxtBankID() {
		return txtBankID;
	}
	public void setTxtBankID(String txtBankID) {
		this.txtBankID = txtBankID;
	}
	public String getTxtItemCode() {
		return txtItemCode;
	}
	public void setTxtItemCode(String txtItemCode) {
		this.txtItemCode = txtItemCode;
	}
	public String getTxtCustomerID() {
		return txtCustomerID;
	}
	public void setTxtCustomerID(String txtCustomerID) {
		this.txtCustomerID = txtCustomerID;
	}
	public String getTxtTxnAmount() {
		return txtTxnAmount;
	}
	public void setTxtTxnAmount(String txtTxnAmount) {
		this.txtTxnAmount = txtTxnAmount;
	}
	public String getRU() {
		return RU;
	}
	public void setRU(String rU) {
		RU = rU;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getTxnDate() {
		return TxnDate;
	}
	public void setTxnDate(String txnDate) {
		TxnDate = txnDate;
	}
	public String getTxnReferenceNo() {
		return TxnReferenceNo;
	}
	public void setTxnReferenceNo(String txnReferenceNo) {
		TxnReferenceNo = txnReferenceNo;
	}
	public String getErrorStatus() {
		return ErrorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		ErrorStatus = errorStatus;
	}
	public String getAuthStatus() {
		return AuthStatus;
	}
	public void setAuthStatus(String authStatus) {
		AuthStatus = authStatus;
	}
	public String getErrorDescription() {
		return ErrorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		ErrorDescription = errorDescription;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTxtAdditionalInfo1() {
		return txtAdditionalInfo1;
	}
	public void setTxtAdditionalInfo1(String txtAdditionalInfo1) {
		this.txtAdditionalInfo1 = txtAdditionalInfo1;
	}
	public String getTxtAdditionalInfo2() {
		return txtAdditionalInfo2;
	}
	public void setTxtAdditionalInfo2(String txtAdditionalInfo2) {
		this.txtAdditionalInfo2 = txtAdditionalInfo2;
	}
	public String getTxtAdditionalInfo3() {
		return txtAdditionalInfo3;
	}
	public void setTxtAdditionalInfo3(String txtAdditionalInfo3) {
		this.txtAdditionalInfo3 = txtAdditionalInfo3;
	}
	public String getTxtAdditionalInfo4() {
		return txtAdditionalInfo4;
	}
	public void setTxtAdditionalInfo4(String txtAdditionalInfo4) {
		this.txtAdditionalInfo4 = txtAdditionalInfo4;
	}
	public String getTxtAdditionalInfo5() {
		return txtAdditionalInfo5;
	}
	public void setTxtAdditionalInfo5(String txtAdditionalInfo5) {
		this.txtAdditionalInfo5 = txtAdditionalInfo5;
	}
	public String getTxtAdditionalInfo6() {
		return txtAdditionalInfo6;
	}
	public void setTxtAdditionalInfo6(String txtAdditionalInfo6) {
		this.txtAdditionalInfo6 = txtAdditionalInfo6;
	}
	public String getTxtAdditionalInfo7() {
		return txtAdditionalInfo7;
	}
	public void setTxtAdditionalInfo7(String txtAdditionalInfo7) {
		this.txtAdditionalInfo7 = txtAdditionalInfo7;
	}
	public String getREQ() {
		return REQ;
	}
	public void setREQ(String rEQ) {
		REQ = rEQ;
	}
	public boolean isValidInputParam() {
		return isValidInputParam;
	}
	public void setValidInputParam(boolean isValidInputParam) {
		this.isValidInputParam = isValidInputParam;
	}
	public boolean isValidInputParam;	

}