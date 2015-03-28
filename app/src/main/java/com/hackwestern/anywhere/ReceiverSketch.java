package com.hackwestern.anywhere;

/**
 * Created by Frieda on 2015-03-28.
 */
public class ReceiverSketch {
    MessageAdapter mAdapter;

    public ReceiverSketch (MessageAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    public void sendMessage () {
        // place photo thumbnail in jpg file and send
        // photo, message, time stamp, location
        mAdapter.notifyDataSetChanged();
    }

    public void receivedMessage () {

    }
}
