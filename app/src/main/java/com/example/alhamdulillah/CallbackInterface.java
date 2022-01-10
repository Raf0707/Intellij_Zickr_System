package com.example.alhamdulillah;

import java.util.*;

public interface CallbackInterface
{
    ArrayList<CallbackInterface> callbacks = new ArrayList<CallbackInterface>();

    void call();
}
