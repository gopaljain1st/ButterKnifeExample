package in.planet.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Battery
{
    @Inject
    public Battery()
    {

    }
    public void ignite()
    {
        Log.d("MY_TAG","Battery is ready");
    }
}
