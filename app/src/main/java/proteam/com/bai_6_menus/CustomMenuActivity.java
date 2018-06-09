package proteam.com.bai_6_menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CustomMenuActivity extends AppCompatActivity {

    private Button nutMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        nutMenu = (Button) findViewById(R.id.chuyenMenu);

        nutMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CustomMenuActivity.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main2,menu);
        SubMenu subMenu = menu.addSubMenu("Moi chon OS");
        subMenu.add(0, 1, 0, "Android");
        subMenu.add(0, 2, 0, "Ios");
        subMenu.add(0, 3, 0, "Windown phone");
        subMenu.add(0, 4, 0, "Win8");
        subMenu.add(0, 5, 0, "Linux ubuntu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(CustomMenuActivity.this, "Ban vua lua chon nut Android", Toast.LENGTH_SHORT).show();
                return true;

            case 2:
                Toast.makeText(CustomMenuActivity.this, "Ban vua lua chon nut ios", Toast.LENGTH_SHORT).show();
                return true;

            case 3:
                Toast.makeText(CustomMenuActivity.this, "Ban vua lua chon nut Windown phone", Toast.LENGTH_SHORT).show();
                return true;

            case 4:
                Toast.makeText(CustomMenuActivity.this, "Ban vua lua chon nut Win 8", Toast.LENGTH_SHORT).show();
                return true;

            case 5:
                Toast.makeText(CustomMenuActivity.this, "Ban vua lua chon nut Linux ubuntu", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
