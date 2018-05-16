package group.usst.singlecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import group.usst.singlecalendar.calendar.SingleCalendar;
import group.usst.singlecalendar.calendar.utils.DateUtil;
import group.usst.singlecalendar.calendar.utils.Transactions;

public class MainActivity extends AppCompatActivity {

    SingleCalendar singleCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleCalendar = findViewById(R.id.mySingleCalendar);
    }
}
