package com.udacity.displayjokes;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Joke extends Fragment {


    public static Joke newInstance() {
        return new Joke();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.joke_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String joke = (String) getActivity().getIntent().getExtras().get("joke");
        System.out.println("joke " +joke);
        TextView jokeText = getActivity().findViewById(R.id.jokeText);
        jokeText.setText(joke);
    }

}
