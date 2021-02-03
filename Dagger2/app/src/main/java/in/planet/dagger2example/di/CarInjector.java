package in.planet.dagger2example.di;

import dagger.Component;
import in.planet.dagger2example.Car;
import in.planet.dagger2example.MainActivity;

@Component
public interface CarInjector
{
    Car getCar();
    void injector(MainActivity mainActivity);
}
