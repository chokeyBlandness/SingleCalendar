package group.usst.singlecalendar.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FrameLinearLayout extends LinearLayout {
    TextView yearAndMonthTextView;
    GridView weekTextGridView;
    GridView  dateGridView;

    public FrameLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public FrameLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FrameLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        this.setOrientation(VERTICAL);
        yearAndMonthTextView = new TextView(context);
        yearAndMonthTextView.setId(Integer.parseInt("yearAndMonthTextView"));
        weekTextGridView = new GridView(context);
        weekTextGridView.setId(Integer.parseInt("weekTextGridView"));
        dateGridView = new GridView(context);
        dateGridView.setId(Integer.parseInt("dateGridView"));
    }
}
