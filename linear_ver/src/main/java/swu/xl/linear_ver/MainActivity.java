package swu.xl.linear_ver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XLRecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setOnItemClickListener(new XLRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, DataUtil.loadData(MainActivity.this).get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
