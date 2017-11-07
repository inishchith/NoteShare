import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class sms_bot {
	
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC0fe86c1432e9f3cd4192d77241c2baf2";
  public static final String AUTH_TOKEN = "c713ee8c60a09862a5c083d067a199c2";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+12019928684"),
        new PhoneNumber("+919820501130"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    System.out.println(message.getSid());
  }
}