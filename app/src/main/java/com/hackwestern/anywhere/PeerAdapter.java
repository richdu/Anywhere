package com.hackwestern.anywhere;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Richard on 2015-03-28.
 */
public class PeerAdapter extends ArrayAdapter{
    private Context context;
    private ArrayList<WifiP2pDevice> peers;

    public PeerAdapter(Context context, ArrayList<WifiP2pDevice> peers)
    {
        super(context, R.layout.row_devices, peers);
        this.peers = peers;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_devices, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.device_name);
        textView.setText(peers.get(position).deviceName);
        return rowView;
    }
}
