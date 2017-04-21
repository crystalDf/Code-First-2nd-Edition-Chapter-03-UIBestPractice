package com.star.uibestpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.msg_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Msg msg = mMsgList.get(position);

        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.mLeftLinearLayout.setVisibility(View.VISIBLE);
            holder.mRightLinearLayout.setVisibility(View.GONE);
            holder.mLeftTextView.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT) {
            holder.mLeftLinearLayout.setVisibility(View.GONE);
            holder.mRightLinearLayout.setVisibility(View.VISIBLE);
            holder.mRightTextView.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLeftLinearLayout;
        private LinearLayout mRightLinearLayout;

        private TextView mLeftTextView;
        private TextView mRightTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mLeftLinearLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            mRightLinearLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);

            mLeftTextView = (TextView) itemView.findViewById(R.id.left_msg);
            mRightTextView = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }
}
