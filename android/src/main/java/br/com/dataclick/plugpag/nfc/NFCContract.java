package br.com.dataclick.plugpag.nfc;

import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagNFCResult;
import br.com.dataclick.plugpag.user.UserData;

public interface NFCContract  {


    //Success
    void showSuccess(UserData result);
    void showSuccessWrite(Object result);
    void showSuccessReWrite(Object result);
    void showSuccessFormat(Object result);
    void showSuccessDebitNfc(Object result);
    void showSuccessRefundNfc(Object result);

    //Error
    void showErrorRead(String message);
    void showErrorWrite(String message);
    void showErrorReWrite(String message);
    void showErrorFormat(String message);
    void showErrorDebitNfc(String message);
    void showErrorRefundNfc(String message);
    void showError(String message);

    void onReadCard();
    void onWriteCard();
    void onAbort();
}