package al.musi.javainterviewquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by re on 2015-11-07.
 */
public class menu1_Fragment extends Fragment {
    private final static String TAG = "menu1_Fragment";
    private View rootview;
    /* Instantiate the parser */
    private XmlQuestionsParser xmlQuestionsParser = new XmlQuestionsParser();
    private List<XmlQuestionsParser.Entry> entries = null;
    private InputStream stream = null;
    private String question = null;
    private String answer = null;
    private String id = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        stream = getResources().openRawResource(R.raw.topjavaquestions);

        try {
            entries = xmlQuestionsParser.parse(stream);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        //TextView textView = (TextView) rootview.findViewById(R.id.textView1);
        //try {
        //} catch (java.lang.NullPointerException e) { Log.d("menu1_Fragment", e.toString()); }

        ExpandableListView listView;
        listView = (ExpandableListView) rootview.findViewById(R.id.expandableListView);

        ArrayList<String> questionList = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();
        //StringBuilder stringBuilder = new StringBuilder();

        for (XmlQuestionsParser.Entry entry : entries) {
            questionList.add(entry.question);
            answerList.add(entry.answer);
        }

        MyExpandableListAdapter listAdapter;
        listAdapter = new MyExpandableListAdapter(inflater, questionList, answerList);

        listView.setAdapter(listAdapter);
        /*StringBuilder stringBuilder = new StringBuilder();
        for (XmlQuestionsParser.Entry entry : entries) {
            stringBuilder.append(entry.id + " " + entry.answer + "\n" + entry.question);
            Log.d("menu1_Fragment", entry.id + " " + entry.answer + "\n" + entry.question);
        }*/

        /*if (textView != null) {
            textView.setText(stringBuilder.toString());
        }*/
        return rootview;
    }
}