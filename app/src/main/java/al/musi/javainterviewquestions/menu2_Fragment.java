package al.musi.javainterviewquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by re on 2015-11-07.
 */
public class menu2_Fragment extends android.support.v4.app.Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        return rootview;
    }
}
