package com.example.anurag.color;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ColorDrawable viewColor;
    LinearLayout final_color;
    ImageButton c1up, c1down, c2up, c2down, c3up, c3down;
    TextView color1, color2, color3;
    int temp, r, g, b, color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color1 = findViewById(R.id.color1);
        color2 = findViewById(R.id.color2);
        color3 = findViewById(R.id.color3);
        c1up = findViewById(R.id.c1up);
        c2up = findViewById(R.id.c2up);
        c3up = findViewById(R.id.c3up);
        c1down = findViewById(R.id.c1down);
        c2down = findViewById(R.id.c2down);
        c3down = findViewById(R.id.c3down);
        final_color = findViewById(R.id.final_color);

        color1.setBackgroundColor(Color.rgb(100, 0, 0));
        color2.setBackgroundColor(Color.rgb(0, 220, 0));
        color3.setBackgroundColor(Color.rgb(0, 0, 150));

        color1.setText("100");
        color2.setText("220");
        color3.setText("150");

        viewColor = (ColorDrawable) color1.getBackground();
        color = viewColor.getColor();
        r = Color.red(color);
        g = Color.green(color);
        b = Color.blue(color);

        final_color.setBackgroundColor(Color.rgb(r,g,b));

        c1up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color1.getText().toString());
                if(temp < 255) {
                    temp += 1;
                    updateRed(temp);
                }
                else{
                    print_toast("Max");
                }
            }
        });

        c1down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color1.getText().toString());
                if(temp > 0) {
                    temp -= 1;
                    updateRed(temp);
                }
                else{
                    print_toast("Min");
                }
             }
        });

        c2up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color2.getText().toString());
                if(temp < 255)
                {
                    temp += 1;
                    updateGreen(temp);
                }
                else{
                    print_toast("Max");
                }
            }
        });

        c2down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color2.getText().toString());
                if(temp > 0)
                {
                    temp -= 1;
                    updateGreen(temp);
                }
                else {
                    print_toast("Min");
                }
            }
        });

        c3up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color3.getText().toString());
                if(temp < 255)
                {
                    temp += 1;
                    updateBlue(temp);
                }
                else{
                    print_toast("Max");
                }
            }
        });

        c3down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.parseInt(color3.getText().toString());
                if(temp > 0)
                {
                    temp -= 1;
                    updateBlue(temp);
                }
                else {
                    print_toast("Min");
                }
            }
        });
    }

    void updateRed(int temp)
    {
        color1.setText(temp+"");
        color1.setBackgroundColor(Color.rgb(temp, 0, 0));
        viewColor = (ColorDrawable) color1.getBackground();
        color = viewColor.getColor();
        r = Color.red(color);
        final_color.setBackgroundColor(Color.rgb(r,g,b));
    }

    void updateGreen(int temp)
    {
        color2.setText(temp+"");
        color2.setBackgroundColor(Color.rgb(0, temp, 0));
        viewColor = (ColorDrawable) color2.getBackground();
        color = viewColor.getColor();
        g = Color.green(color);
        final_color.setBackgroundColor(Color.rgb(r,g,b));
    }

    void updateBlue(int temp)
    {
        color3.setText(temp+"");
        color3.setBackgroundColor(Color.rgb(0, 0, temp));
        viewColor = (ColorDrawable) color3.getBackground();
        color = viewColor.getColor();
        b = Color.blue(color);
        final_color.setBackgroundColor(Color.rgb(r,g,b));
    }

    void print_toast(String s)
    {
        Toast.makeText(MainActivity.this, s+" value reached", Toast.LENGTH_SHORT).show();
    }
}