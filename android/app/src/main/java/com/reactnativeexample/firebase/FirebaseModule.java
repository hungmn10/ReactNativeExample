package com.reactnativeexample.firebase;


import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseModule extends ReactContextBaseJavaModule {
    private ReactContext reactContext;

    public FirebaseModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FirebaseModule";
    }

    @ReactMethod
    public void getMessage(final Callback callback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message/user");
        Query query = myRef.orderByChild("name").equalTo("dungtrihp");
//        Message message = new Message("dungtrihp", "hello");
//        myRef.push().setValue(message);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("dungtrihp123456", "Value is: " + snapshot);
                }

                long count = dataSnapshot.getChildrenCount();

                Log.d("dungtrihp123456", "Value is: " + count);

                WritableMap params = Arguments.createMap();
                params.putString("key", count + "");
                callback.invoke(params);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("dungtrihp123456", "Failed to read value.", error.toException());
            }
        });
    }

    public class Message {
        public String name;
        public String content;

        public Message(String name, String content) {
            this.name = name;
            this.content = content;
        }
    }
}
