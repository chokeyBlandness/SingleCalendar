package group.usst.singlecalendar.calendar.utils;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public interface Transactions {
    /**
     * manipulate the textView you want
     * @param date the date of the textView would be manipulated
     * @param textView the textView would be manipulated
     */
    void manipulateTextView(Date date, TextView textView);

    /**
     * manipulate the icon you want
     * @param date the date of the textView would be manipulated
     * @param iconView the iconView would be manipulated
     */
    void manipulateIconView(Date date, ImageView iconView);
}
