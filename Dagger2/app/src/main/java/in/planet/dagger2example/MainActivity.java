package in.planet.dagger2example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import in.planet.dagger2example.di.DaggerCarInjector;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car hondaCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Car hondaCar= DaggerCarInjector.create().getCar();
        DaggerCarInjector.create().injector(this);
        hondaCar.drive();
    }
}