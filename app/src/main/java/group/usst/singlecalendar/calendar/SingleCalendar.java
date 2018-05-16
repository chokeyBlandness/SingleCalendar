package group.usst.singlecalendar.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import group.usst.singlecalendar.R;
import group.usst.singlecalendar.calendar.utils.DateAdapter;
import group.usst.singlecalendar.calendar.utils.DateUtil;
import group.usst.singlecalendar.calendar.utils.Transactions;
import group.usst.singlecalendar.calendar.utils.WeekAdapter;

public class SingleCalendar extends LinearLayout {
    TextView yearAndMonthTextView;
    GridView weekTextGridView;
    GridView dateGridView;
    DateAdapter dateAdapter;

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
        View view = LayoutInflater.from(context).inflate(R.layout.frame_layout,this);
        yearAndMonthTextView = view.findViewById(R.id.yearAndMonthTextView);
        weekTextGridView = view.findViewById(R.id.weekTextGridView);
        dateGridView = view.findViewById(R.id.dateGridView);
        yearAndMonthTextView.setText(DateUtil.getCurrentYear()+"-"+(DateUtil.getCurrentMonth()+1));
        weekTextGridView.setAdapter(new WeekAdapter(getContext()));
        dateAdapter = new DateAdapter(getContext());
        dateGridView.setAdapter(dateAdapter);

    }

    public void setTransactions(Transactions transactions) {
        this.dateAdapter.setTransactions(transactions);
    }
}
