package in.planet.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Car
{
  Battery battery;
  Engine engine;
  @Inject
  public Car(Battery battery,Engine engine)
  {
      this.battery=battery;
      this.engine=engine;
  }
  public void drive()
  {
      battery.ignite();
      engine.start();
      Log.d("MY_TAG","Car Is Driving");
  }
}
