package com.hackwestern.anywhere;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Frieda on 2015-03-28.
 */
public class MessageAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Message> messages;

    public MessageAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.list_item, messages);

        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        // Load the rowView with the message-specific data
        if (messages.get(position).getSelf()) { // message sent by the user
            ImageView imageView = (ImageView) rowView.findViewById(R.id.thumbnail);
            imageView.setImageURI(Uri.parse(messages.get(position).getURI()));


            TextView textView = (TextView) rowView.findViewById(R.id.message);
            textView.setText(messages.get(position).getText());
            textView.setTextColor(Color.parseColor("#E0E0E0"));
            textView.setBackgroundColor(Color.parseColor("#80CBC4"));
        }
        else {
            ImageView imageView = (ImageView) rowView.findViewById(R.id.thumbnail);
            imageView.setImageURI(Uri.parse(messages.get(position).getURI()));

            TextView textView = (TextView) rowView.findViewById(R.id.message);
            textView.setText(messages.get(position).getText());
            //textView.setTextColor(textColor[position % textColor.length]);
            //textView.setBackgroundColor(backgroundColor[position % backgroundColor.length]);
        }
        return rowView;
    }

    public void add (Message message) {
        messages.add(message);
    }
}
