package fake;

import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.UserContact;
import org.telegram.api.TLAbsUser;
import org.telegram.api.TLUserContact;
import org.telegram.api.auth.TLAuthorization;

import java.io.IOException;
import java.util.ArrayList;

public class FakeTelegramBridge {

    public ArrayList<UserContact> contactsGetContacts()throws IOException {
        ArrayList<UserContact> contacts = new ArrayList<>();
        contacts.add(new UserContact(new TLUserContact(1, "Misha ", " Petrov",
                1111, "+71111111111",
                null, null)));
        contacts.add(new UserContact(new TLUserContact(1, "Ivav ", " Ivanov",
                1111, "+72222222222",
                null, null)));
        contacts.add(new UserContact(new TLUserContact(1, "Masha ", " Sidorova",
                1111, "+73333333333",
                null, null)));
        return contacts;
    }

    public AuthSentCode authSendCode(String phoneText) throws IOException{
        return new AuthSentCode(true, "12345");
    }

    public AuthCheckedPhone authCheckPhone(String phoneText)throws IOException {
        return new AuthCheckedPhone(true, false);
    }

    public AuthAuthorization authSignIn (String smsCode)throws IOException {
        if (smsCode.equals("1234")) {
            return new AuthAuthorization(new TLAuthorization(100, new TLAbsUser() {
                @Override
                public int getClassId() {
                    return 0;
                }
            }));
        } else
            throw new IOException("Неправильный SMS код");
    }

    public AuthAuthorization authSignUp (String smsCode, String firstName, String lastName)throws IOException{
        return new AuthAuthorization(new TLAuthorization(1, new TLAbsUser() {
            @Override
            public int getClassId() {
                return 1;
            }
        }));
    }

    public void authLogOut() throws IOException{}
}
