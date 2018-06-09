package proteam.com.bai_6_menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnContextMenu;
    Button btnPopupMenu;
    Button btnCustomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        //Đăng ký ContextMenu cho button,long click to open context menu
        registerForContextMenu(btnContextMenu);

        btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu);
        btnPopupMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khởi tạo 1 popupmenu
                //notes: do not using getApplicationContext to show Popupmenu, Dialogs...
                //PopupMenu popupMenu = new PopupMenu(getApplicationContext(), btnPopupMenu);
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopupMenu);
                //đẩy layout của mình vừa tạo ở trên vào ứng dụng
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                //Sự kiện click vào item của menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, "You Clicked : " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        btnCustomMenu = (Button) findViewById(R.id.btnCustomMenu);
        btnCustomMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    //Nạp contextmenu mà chúng ta vừa tạo vào ứng dụng
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    //Xử lý sự kiện khi click vào từng item
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnRed:
                Toast.makeText(getApplicationContext(), "Red clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnGreen:
                Toast.makeText(getApplicationContext(), "Green clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnBlue:
                Toast.makeText(getApplicationContext(), "Blue clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bookmark:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Selected",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_save:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Save",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Search",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_share:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Share",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Delete",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_preferences:
                Toast.makeText(MainActivity.this, "Ban vua chon nut Preferences",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
