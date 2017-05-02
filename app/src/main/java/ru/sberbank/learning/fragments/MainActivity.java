package ru.sberbank.learning.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements TestFragmentHost {

    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =
                        getFragmentManager().beginTransaction();

                transaction.add(R.id.main_layout, new ButtonFragment());

                TestFragment four = TestFragment.newInstance("Four");
                transaction.add(R.id.main_layout, four, "foo");

                transaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.activity_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_in_activity:

                Fragment fragment = getFragmentManager().findFragmentByTag("foo");
                if (fragment != null) {
                    getFragmentManager()
                            .beginTransaction()
                            .remove(fragment)
                            .commit();
                }

                return true;

            case R.id.action_dialog:
                AlertDialogFragment
                        .newInstance(getString(R.string.dialog_fragment))
                        .show(getFragmentManager(), null);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeText(String text) {
        TestFragment fragment = (TestFragment) getFragmentManager()
                .findFragmentByTag("foo");

        if (fragment != null) {
            fragment.setText(text);
        }
    }
}
