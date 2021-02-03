package in.planet.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Engine
{
    @Inject
    public Engine()
    {

    }
    public void start()
    {
        Log.d("MY_TAG","Engine Has Started");
    }
}
