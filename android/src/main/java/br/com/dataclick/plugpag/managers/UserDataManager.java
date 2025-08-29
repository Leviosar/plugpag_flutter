package br.com.dataclick.plugpag.managers;



import br.com.dataclick.plugpag.user.UserData;
import br.com.dataclick.plugpag.user.usecase.DebitUserUseCase;
import br.com.dataclick.plugpag.user.usecase.EditUserUseCase;
import br.com.dataclick.plugpag.user.usecase.GetUserUseCase;
import br.com.dataclick.plugpag.user.usecase.NewUserUseCase;
import br.com.dataclick.plugpag.user.usecase.RefundUserUseCase;
import io.reactivex.Observable;
import io.reactivex.Single;

public class UserDataManager {

    private GetUserUseCase mGetUser;
    private NewUserUseCase mNewUser;
    private EditUserUseCase mEditUser;
    private RefundUserUseCase mRefundUser;
    private DebitUserUseCase mDebitUser;

    public UserDataManager(GetUserUseCase getUser, NewUserUseCase newUser, EditUserUseCase mEditUser, DebitUserUseCase mDebitUser, RefundUserUseCase mRefundUser) {
        this.mGetUser = getUser;
        this.mNewUser = newUser;
        this.mEditUser = mEditUser;
        this.mDebitUser = mDebitUser;
        this.mRefundUser = mRefundUser;
    }

    public Single<UserData> getUserData(String idEvento){
        return mGetUser.getUser(idEvento);
    }

    public Observable<Integer> writeUserData(UserData userData){
        return mNewUser.writeUserInNFcCard(userData);
    }

    public Observable<String> reWriteUserData(UserData userData){
        return mEditUser.reWriteUserInNFcCard(userData);
    }

    public Observable<String> reFundUserData(UserData userData){
        return mRefundUser.reFundUserInNFcCard(userData);
    }

    public Observable<String> debitUserData(UserData userData){
        return mDebitUser.debitInNFcCard(userData);
    }
}
