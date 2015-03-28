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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PeersListFragment extends Fragment implements WifiP2pManager.PeerListListener{
    private SearchClicked mListener;
    private ArrayList<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();
    private PeerAdapter peerAdapter;
    private ListView listView;
    private Button button;

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

        button = (Button) view.findViewById(R.id.searchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSearchClicked();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (SearchClicked) activity;
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
    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        peers.clear();
        peers.addAll(peerList.getDeviceList());
        peerAdapter.notifyDataSetChanged();
        if (peers.size() == 0) {
            Log.d("TAG", "No devices found");
        }
        Log.d("TAG", "changed");
    }

    public interface SearchClicked {
        public void onSearchClicked();
    }

}
