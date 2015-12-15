package com.tokko.cameandwent.robot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;


public class ToggleLedFragment extends RoboFragment implements CompoundButton.OnCheckedChangeListener, IUsbConnectionHandler {
    @InjectView(R.id.toggleledfragment_ToggleLedToggleButton) private ToggleButton toggleledToggleButton;
    private UsbController usbController;

    public static ToggleLedFragment newInstance() {
        return new ToggleLedFragment();
    }

    public ToggleLedFragment() {}
    private static final int VID = 0x2341;
    private static final int PID = 0x0001;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usbController = new UsbController(getActivity(), this, VID, PID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_toggle_led, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toggleledToggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        usbController.send((byte)(isChecked?0:1));
    }

    @Override
    public void onUsbStopped() {

    }

    @Override
    public void onErrorLooperRunningAlready() {

    }

    @Override
    public void onDeviceNotFound() {

    }
}
