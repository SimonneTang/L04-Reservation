package sg.edu.rp.c346.id20025732.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    TextView name;
    EditText editname;
    TextView number;
    EditText editnumber;
    TextView numppl;
    EditText numpax;
    CheckBox smoking;
    TextView pickdate;
    DatePicker dp;
    TextView picktime;
    TimePicker tp;
    Button done;
    Button reset;
    TextView display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textViewName);
        editname = findViewById(R.id.editTextName);
        number = findViewById(R.id.textViewNumber);
        editnumber = findViewById(R.id.editTextNumber);
        numppl = findViewById(R.id.textViewNumpax);
        numpax = findViewById(R.id.editTextNumpax);
        smoking = findViewById(R.id.checkBoxsmoking);
        pickdate = findViewById(R.id.textViewDatepicker);
        dp = findViewById(R.id.datePicker);
        picktime = findViewById(R.id.textViewTimepicker);
        tp = findViewById(R.id.timePicker);
        done = findViewById(R.id.buttondone);
        reset = findViewById(R.id.buttonreset);
        display = findViewById(R.id.displayreserve);


        dp.updateDate(2021,5,1);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etname = editname.getText().toString();
                String hpnum = editnumber.getText().toString();
                String etpax = numpax.getText().toString();

                String isSmoking = " ";
                if (smoking.isChecked()){
                    isSmoking = "Smoking ";
                }
                else{
                    isSmoking = "Non-smoking ";
                }

                String date = dp.getDayOfMonth() + "/" +(dp.getMonth()+1) + "/" + dp.getYear();
                String time = tp.getCurrentHour()  + ":" + tp.getCurrentMinute();

                String msg = "Hello! " + etname + "You have reserved a table under the number "
                        + hpnum + "for " + etpax + "pax. Your date is " + date + " at " + time +
                        " for a " + isSmoking + "table";

                Toast.makeText(MainActivity.this, "Confirming Reservation", Toast.LENGTH_LONG).show();

                display.setText(msg);




            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2021,5,1);
                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);
                editname.setText(" ");
                editnumber.setText(" ");
                numpax.setText(" ");
                display.setText(" ");



            }
        });

    }
}