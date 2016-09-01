package com.example.givemepass.custommenudemo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;


public class OptionDialog extends Dialog{
    public static final int ITEM1 = 0;
    public static final int ITEM2 = 1;
    private OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(int pos);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }
    public OptionDialog(Context context) {
        super(context, R.style.AppTheme);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.option_dialog);
        findViewById(R.id.item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(ITEM1);
                }
            }
        });
        findViewById(R.id.item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(ITEM2);
                }
            }
        });
    }
}
