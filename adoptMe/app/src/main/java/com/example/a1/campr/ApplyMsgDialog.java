package com.example.a1.campr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class ApplyMsgDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.application_msg, null))
                .setPositiveButton(R.string.apply_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myListener.onDialogPositiveClick(ApplyMsgDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancel_dialog, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ApplyMsgDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public interface ApplyMsgListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        //public void onDialogNegativeClick(DialogFragment dialog);
    }

    ApplyMsgListener myListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            myListener = (ApplyMsgListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString());
        }
    }
}
