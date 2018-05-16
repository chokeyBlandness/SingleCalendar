package group.usst.singlecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import group.usst.singlecalendar.calendar.SingleCalendar;
import group.usst.singlecalendar.calendar.utils.DateUtil;
import group.usst.singlecalendar.calendar.utils.Transactions;

public class MainActivity extends AppCompatActivity {


    /**
     * to manipulate the SingleCalendar,what you need to do is to
     * initialize Transactions, and use SingleCalendar's setTransactions() method
     * to inject the Transactions
     */
    SingleCalendar singleCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleCalendar = findViewById(R.id.mySingleCalendar);

        //example
        Transactions transactions=new Transactions() {
            @Override
            public void manipulateTextView(Date date, TextView textView) {
                Calendar calendar = Calendar.getInstance();
                if (date.getDate() == calendar.get(Calendar.DATE)) {
                    textView.setText("t");
                }
            }

            @Override
            public void manipulateIconView(Date date, ImageView iconView) {
                Calendar calendar = Calendar.getInstance();
                if (date.getDate() == calendar.get(Calendar.DATE)) {
                    iconView.setVisibility(View.VISIBLE);
                }
            }
        };
        singleCalendar.setTransactions(transactions);
    }
}
