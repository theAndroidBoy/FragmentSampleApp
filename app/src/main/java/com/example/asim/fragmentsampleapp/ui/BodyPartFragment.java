package com.example.asim.fragmentsampleapp.ui;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asim.fragmentsampleapp.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private final String TAG="flow";
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
    private List<Integer> mImageIds;
    private int mListIndex=0;

    public BodyPartFragment() {
        Log.d(TAG, "BodyPartFragment: constructor");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }

        // Return the rootView
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        Log.d(TAG, "setImageIds: ");
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        Log.d(TAG, "setListIndex: ");
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        Log.d(TAG, "onSaveInstanceState: ");
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }


}
