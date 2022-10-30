import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
    public static boolean isThisDateValid(String dateToValidate) {
        if (dateToValidate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToValidate);
            if (20>date.getYear() || 115<date.getYear())
                System.out.println("incorrect year");
//                return false;
        } catch (ParseException e) {
            System.out.println("incorrect date of birth");
            return false;
        }
        return true;
    }
}
