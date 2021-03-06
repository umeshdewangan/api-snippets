// Install the Java helper library from twilio.com/docs/java/install
import org.joda.time.LocalDate;

import com.google.common.collect.Range;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Conference;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<Conference> conferences = Conference.reader()
        .setStatus(Conference.Status.IN_PROGRESS)
        .setDateCreated(Range.atLeast(LocalDate.parse("2009-07-06")))
        .read();

    // Loop over conferences and print out a property for each one.
    for (Conference conference : conferences) {
      System.out.println(conference.getSid());
    }
  }
}
