package al.musi.javainterviewquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by re on 2015-11-07.
 */
public class menu2_Fragment extends Fragment {
    private final static String TAG = "menu2_Fragment";
    private View rootview;
    /* Instantiate the parser */
    private XmlQuestionsParser xmlQuestionsParser = new XmlQuestionsParser();
    private List<XmlQuestionsParser.Entry> entries = null;
    private InputStream stream = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        stream = getResources().openRawResource(R.raw.corejavaquestions);

        try {
            entries = xmlQuestionsParser.parse(stream);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        ExpandableListView listView;
        listView = (ExpandableListView) rootview.findViewById(R.id.expandableListView2);

        ArrayList<String> questionList = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();

        for (XmlQuestionsParser.Entry entry : entries) {
            questionList.add(entry.question);
            answerList.add(entry.answer);
        }

        MyExpandableListAdapter listAdapter;
        listAdapter = new MyExpandableListAdapter(inflater, questionList, answerList);
        if( listView != null) {
            listView.setAdapter(listAdapter);
        }else {
            Log.e(TAG, "listView == null");
        }
        return rootview;
    }
}
