package com.star.uibestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> mMsgList;

    private EditText mInputText;
    private Button mSendButton;

    private RecyclerView mRecyclerView;

    private MsgAdapter mMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();

        mInputText = findViewById(R.id.input_text);
        mSendButton = findViewById(R.id.send);

        mRecyclerView = findViewById(R.id.msg_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mMsgAdapter = new MsgAdapter(mMsgList);
        mRecyclerView.setAdapter(mMsgAdapter);

        mSendButton.setOnClickListener(v -> {

            String content = mInputText.getText().toString();

            if (!TextUtils.isEmpty(content)) {
                Msg msg = new Msg(content, Msg.TYPE_SENT);
                mMsgList.add(msg);

                mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                mRecyclerView.scrollToPosition(mMsgList.size() - 1);

                mInputText.setText("");
            }
        });

    }

    private void initMsgs() {

        mMsgList = new ArrayList<>();

        Msg msg1 = new Msg("Hello, guy.", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);

        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        mMsgList.add(msg2);

        Msg msg3 = new Msg("This is Star. Nice talking to you.", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }
}
