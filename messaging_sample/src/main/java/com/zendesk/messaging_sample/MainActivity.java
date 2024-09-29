package com.zendesk.messaging_sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import zendesk.chat.ChatConfiguration;
import zendesk.chat.ChatEngine;
import zendesk.chat.PreChatFormFieldStatus;
import zendesk.classic.messaging.Engine;
import zendesk.classic.messaging.MessagingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Global.isMissingCredentials()) {
            setContentView(R.layout.missing_credentials);
            return;
        }

        ChatConfiguration chatConfiguration = ChatConfiguration.builder()
                .withAgentAvailabilityEnabled(false)
                .withPreChatFormEnabled(true)
                .withNameFieldStatus(PreChatFormFieldStatus.OPTIONAL)
                .withEmailFieldStatus(PreChatFormFieldStatus.REQUIRED)
                .withPhoneFieldStatus(PreChatFormFieldStatus.HIDDEN)
                .withDepartmentFieldStatus(PreChatFormFieldStatus.REQUIRED)
                .build();

        MessagingActivity.builder()
                .withEngines(ChatEngine.engine())
                .show(this);
    }
}
