package group.usst.singlecalendar.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import group.usst.singlecalendar.R;
import group.usst.singlecalendar.calendar.utils.DateAdapter;
import group.usst.singlecalendar.calendar.utils.DateUtil;
import group.usst.singlecalendar.calendar.utils.Transactions;
import group.usst.singlecalendar.calendar.utils.WeekAdapter;

public class SingleCalendar extends LinearLayout {
    ImageView preMonthButton;
    ImageView nextMonthButton;

    TextView yearAndMonthTextView;
    GridView weekTextGridView;
    GridView dateGridView;
    DateAdapter dateAdapter;

    Calendar calendar;


    public SingleCalendar(Context context) {
        super(context);
        init(context);
    }

    public SingleCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SingleCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.frame_layout,this);
        preMonthButton = view.findViewById(R.id.preMonthButton);
        nextMonthButton = view.findViewById(R.id.nextMonthButton);
        yearAndMonthTextView = view.findViewById(R.id.yearAndMonthTextView);
        weekTextGridView = view.findViewById(R.id.weekTextGridView);
        dateGridView = view.findViewById(R.id.dateGridView);
        weekTextGridView.setAdapter(new WeekAdapter(getContext()));
        renderView(calendar);
        preMonthButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,-1);//change to past month
                renderView(calendar);
            }
        });
        nextMonthButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,1);//change to next month
                renderView(calendar);
            }
        });
    }

    /**
     * render views to show year , month and the month's date
     * @param manipulateCalendar the calendar of the month will be rendered
     */
    void renderView(Calendar manipulateCalendar) {
        yearAndMonthTextView.setText(DateUtil.getCalendarYear(manipulateCalendar)+
                "-"+(DateUtil.getCalendarMonth(manipulateCalendar)+1));
        dateAdapter = new DateAdapter(getContext(), manipulateCalendar);
        dateGridView.setAdapter(dateAdapter);
    }

    public void setTransactions(Transactions transactions) {
        this.dateAdapter.setTransactions(transactions);
    }
}
