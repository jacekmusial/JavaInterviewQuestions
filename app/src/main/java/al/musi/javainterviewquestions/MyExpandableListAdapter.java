package al.musi.javainterviewquestions;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "ExpendableListAdapter";
    private ArrayList<String> childtems;
    private ArrayList<String> parentItems;
    private LayoutInflater inflater;

    public MyExpandableListAdapter (LayoutInflater inflater, ArrayList<String> parents, ArrayList<String> childern) {
        this.inflater = inflater;
        this.parentItems = parents;
        this.childtems = childern;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.answer_layout, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.answer_layout);
        String child = childtems.get(groupPosition);
        textView.setText(child);

        Log.d(TAG, "getChildView(): textView.setText( " + child + " )");

        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.question_layout, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.question_layout);
        textView.setText(parentItems.get(groupPosition));

        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;//(childtems.get(groupPosition)).length();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}