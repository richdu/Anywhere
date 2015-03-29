package com.hackwestern.anywhere;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Frieda on 2015-03-28.
 */
public class MainFragment extends Fragment {

    private ListView listView;
    private MessageAdapter mAdapter;
    private Button send;
    private EditText text;
    private Contact contact;


    public MainFragment () {
    }

    public void setContact (Contact contact) {
        this.contact = contact;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        // Create the adapter
        mAdapter = new MessageAdapter (getActivity().getApplicationContext(), getMessageArray ());
    }

    public ArrayList<Message> getMessageArray () {
        ArrayList<Message> messages = new ArrayList<Message>();


        return messages;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Set the contact name
        TextView textView = (TextView)view.findViewById (R.id.text_view);
        if (contact != null)
            textView.setText (contact.getName ());

        // Set the adapter
        listView = (ListView) view.findViewById (R.id.list);
        listView.setAdapter (mAdapter);

        //Editable text
        text = (EditText) view.findViewById(R.id.edit_text);

        //Button
        send = (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Message message = new Message ("URI", text.getText().toString(), true);
                    mAdapter.add(message);
                    mAdapter.notifyDataSetChanged();
                    text.setText("");
                listView.smoothScrollToPosition(mAdapter.getCount() - 1);
            }
        });
        return view;
    }
}
