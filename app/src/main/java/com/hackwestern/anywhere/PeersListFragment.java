package com.hackwestern.anywhere;

import android.app.Activity;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PeersListFragment extends Fragment implements WifiP2pManager.PeerListListener{
    private OnFragmentInteractionListener mListener;
    private ArrayList<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();
    private PeerAdapter peerAdapter;
    private ListView listView;

    public static PeersListFragment newInstance() {
        PeersListFragment fragment = new PeersListFragment();
        return fragment;
    }

    public PeersListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        peerAdapter = new PeerAdapter(getActivity(), peers);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peers_list, container, false);
        listView = (ListView) view.findViewById(R.id.peersListView);
        listView.setAdapter(peerAdapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPeersAvailable(WifiP2pDeviceList peers) {
        this.peers.clear();
        this.peers.addAll(peers.getDeviceList());
        peerAdapter.notifyDataSetChanged();
        Log.d("TAG", "changed");
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
