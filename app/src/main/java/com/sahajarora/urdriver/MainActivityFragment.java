package com.sahajarora.urdriver;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sahajarora.urdriver.helper.SQLiteHandler;
import com.sahajarora.urdriver.helper.SessionManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private Button btnParty, btnAirport, btnValet, btnCancelBooking;
    private SQLiteHandler db;
    private SessionManager session;
    public static String driverType;
    private View view;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_main_activity_fragment, container, false);

        // SqLite database handler
        db = new SQLiteHandler(getActivity().getApplicationContext());

        // session manager
        session = new SessionManager(getActivity().getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        btnParty = (Button) view.findViewById(R.id.btnParty);
        btnAirport = (Button) view.findViewById(R.id.btnAirport);
        btnValet = (Button) view.findViewById(R.id.btnValet);
        btnCancelBooking = (Button) view.findViewById(R.id.btnCancelBooking);

        btnParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driverType = "Party";
                Intent i = new Intent(getActivity(), DriverActivity.class);
                startActivity(i);
            }
        });

        btnAirport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driverType = "Airport";
                Intent i = new Intent(getActivity(), DriverActivity.class);

                startActivity(i);
            }
        });

        btnValet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driverType = "Valet";
                startActivity(new Intent(getActivity(), DriverActivity.class));
            }
        });
        return view;
    }

    public void logoutUser() {


        session.setLogin(false);

        db.deleteUsers();
        Toast.makeText(getActivity().getApplicationContext(), "You have been logged out!", Toast.LENGTH_LONG).show();
        // Launching the login activity
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}
