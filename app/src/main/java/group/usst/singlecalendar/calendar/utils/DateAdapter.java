package group.usst.singlecalendar.calendar.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import group.usst.singlecalendar.R;

public class DateAdapter extends BaseAdapter {

    Context context;
    Calendar calendar;
    Transactions transactions;

    /**
     * constructor function with a context parameter
     * @param context the context would be injected
     */
    public DateAdapter(Context context, Calendar calendar) {
        this.context = context;
        this.calendar = calendar;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return DateUtil.getCalendarMonthLastDay(calendar)+DateUtil.getFirstDayOfMonth(calendar)-1;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     * data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        int i;
        if (position < DateUtil.getFirstDayOfMonth(calendar) - 1) {
            i = 0;
        } else {
            i = position + 1 - (DateUtil.getFirstDayOfMonth(calendar) - 1);
        }
        return i;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position The position of the item within the adapter's data set of the item whose view
     *        we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *        is non-null and of an appropriate type before using. If it is not possible to convert
     *        this view to display the correct data, this method can create a new view.
     *        Heterogeneous lists can specify their number of view types, so that this View is
     *        always of the right type (see {@link #getViewTypeCount()} and
     *        {@link #getItemViewType(int)}).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.component_layout,null);
        }

        Date date = new Date(DateUtil.getCalendarYear(calendar),
                DateUtil.getCalendarMonth(calendar),
                (Integer) getItem(position));

        TextView textView = convertView.findViewById(R.id.textComponent);
        ImageView imageView = convertView.findViewById(R.id.iconImageVIew);
        if (position < DateUtil.getFirstDayOfMonth(calendar) - 1) {
            textView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(getItem(position)+"");
            if (transactions != null) {
                transactions.manipulateTextView(date,textView);
                transactions.manipulateIconView(date,imageView);
            }
        }
        return convertView;
    }

    /**
     * set transaction to manipulate textView and iconView
     * @param transactions the injected transactions
     */
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}
